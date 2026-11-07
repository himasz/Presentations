"""Tests for every code sample in the lecture deck.  Run:  pytest -q   (Python 3.10+)"""
import gc
import importlib
import threading

import pytest


def load(name):
    return importlib.import_module(name)


# ---- Intro ------------------------------------------------------------------
def test_abc_refuses_instantiation_and_incomplete_subclasses():
    m = load("i1_abc")
    with pytest.raises(TypeError):
        m.SuperPower()

    class Lazy(m.SuperPower):
        pass

    with pytest.raises(TypeError):
        Lazy()
    assert m.Fly().exercise_power() == "Up, Up, and Away!"


def test_protocol_fits_by_shape():
    m = load("i1_protocol")
    assert m.power.exercise_power() == "Up, Up, and Away!"
    assert m.SuperPower not in type(m.power).__mro__


# ---- Part 1: inheritance vs composition ---------------------------------------
def test_inheritance_trap_loses_a_behaviour():
    assert load("a1_inheritance_trap").FlyingFightingHero().act() == "Up, Up, and Away!"


def test_composition_combines_behaviours():
    m = load("a2_composition")
    assert m.Hero(m.Fly(), m.Fight()).act() == "Up, Up, and Away! / KaBaam!"


def test_inherited_stack_leaks_list_api():
    m = load("a3_stack_inherit")
    s = m.Stack(); s.push(1); s.push(2); s.insert(0, 99)
    assert s == [99, 1, 2]            # LIFO broken
    assert m.s == []                  # the module's own demo ends with clear()


def test_composed_stack_hides_list_api():
    m = load("a3_stack_compose")
    s = m.Stack(); s.push(1); s.push(2)
    assert s.pop() == 2 and len(s) == 1
    with pytest.raises(AttributeError):
        s.insert(0, 99)


# ---- Part 2: SOLID ------------------------------------------------------------
class _Order:
    def __init__(self, price): self.price = price


def test_srp_before_and_after_produce_same_html(tmp_path):
    before, after = load("b1_srp_before"), load("b1_srp_after")
    orders = [_Order(10), _Order(5.5)]
    html = after.HtmlFormatter().format(after.SalesReport(orders))
    assert before.SalesReport(orders).to_html() == html == "<h1>15.50</h1>"
    p = tmp_path / "r.html"
    after.FileStore().save(str(p), html)
    assert p.read_text() == html


@pytest.mark.parametrize("kind,cls", [("regular", "Regular"), ("student", "Student"), ("vip", "Vip")])
def test_ocp_same_results(kind, cls):
    before, after = load("b2_ocp_before"), load("b2_ocp_after")
    assert before.checkout(100, kind) == after.checkout(100, getattr(after, cls)())
    assert after.checkout(100, after.Student()) == 90.0


def test_lsp_violation_crashes_callers():
    m = load("b3_lsp_before"); from characters import BadGuy
    with pytest.raises(Exception, match="Bad guys don't flee!"):
        m.retreat([m.BadGuyAdapter(BadGuy())])


def test_lsp_fix_has_no_flee():
    m = load("b3_lsp_after"); from characters import BadGuy
    boris = m.BadGuyAdapter(BadGuy())
    assert (boris.chase(), boris.attack()) == (30, 50)
    assert not hasattr(boris, "flee")


def test_isp():
    m = load("b4_isp_after")
    assert m.cheese_pizza(m.VeggieKitchen()) == ["wheat", "tomato", "vegan"]
    with pytest.raises(TypeError):           # fat ABC: VeggieKitchen is still abstract
        load("b4_isp_before").VeggieKitchen()


def test_dip():
    m = load("b5_dip_after")
    repo = m.InMemoryRepo()
    m.OrderService(repo).place({"id": 1})
    assert repo.rows == [{"id": 1}]


# ---- Part 3: creational --------------------------------------------------------
def test_singleton_classic_is_thread_safe():
    m = load("c1_singleton_classic")
    seen = []
    threads = [threading.Thread(target=lambda: seen.append(m.Settings())) for _ in range(50)]
    for t in threads: t.start()
    for t in threads: t.join()
    assert all(s is seen[0] for s in seen)
    m.Settings().some_value = 42
    assert m.Settings().some_value == 42


def test_singleton_pythonic():
    m = load("c1_singleton_pythonic")
    m.get_settings().some_value = 7
    assert m.get_settings().some_value == 7


def test_simple_factory():
    m = load("c2_simple_factory"); from pizza import CheesePizza, PizzaType
    assert isinstance(m.pizza, CheesePizza)
    assert [m.factory.create_pizza(t).kind for t in PizzaType] == list(PizzaType)
    with pytest.raises(KeyError):
        m.factory.create_pizza("hawaiian")


def test_factory_method():
    m = load("c3_factory_method"); from pizza import PizzaType
    assert (m.pizza.dough, m.pizza.steps) == ("deep dish", ["prepare", "bake", "cut", "box"])
    assert m.NewYorkStore().order_pizza(PizzaType.CHEESE).dough == "thin"


def test_abstract_factory():
    a = load("c4a_abstract_factory"); m = load("c4b_abstract_factory_client")
    assert m.CheesePizza(a.ChicagoIngredients()).prepare() == ["deep dish", "plum tomato", "mozzarella"]
    assert m.CheesePizza(a.NewYorkIngredients()).prepare() == ["thin crust", "marinara", "reggiano"]


# ---- Part 3: structural (numbers match the repo's xUnit tests) ------------------
def test_adapter():
    m = load("d1_adapter")
    assert (m.m.attack(), m.m.chase(), m.m.flee()) == (10, 5, 5)


def test_decorator():
    m = load("d2a_decorator"); s = load("d2b_decorator_stack"); b = m.BaseCar()
    a = m.ArmoredCar(b); r = s.RaceCar(b)
    assert (a.drive, a.attack, a.defend) == (80, 100, 140)
    assert (r.drive, r.attack, r.defend) == (140, 90, 90)
    assert (s.car.drive, s.car.attack, s.car.defend) == (100, 90, 170)
    assert (m.armored.drive, m.armored.defend) == (80, 140)


def test_facade():
    m = load("d3_facade"); api = m.BetterApi()
    assert api.add_three_numbers(1, 2, 3) == 6
    assert api.add_then_multiply(4, factor=5) == 20
    assert api.add_then_multiply(4, 3, factor=5) == 35
    assert api.add_then_multiply(4, 3, 2, factor=5) == 45


# ---- Part 3: behavioural ---------------------------------------------------------
def test_strategy():
    p = load("e1a_strategy_powers"); m = load("e1b_strategy_hero")
    s = m.SpiderMan()
    assert s.do_hero_stuff() == "Catches Thieves Like Flies!"
    s.change_super_power(p.Fly())
    assert s.do_hero_stuff() == "Up, Up, and Away!"
    assert m.spidey.do_hero_stuff() == "Up, Up, and Away!"
    assert m.Hero(p.WeaveWeb()).do_hero_stuff() == "Catches Thieves Like Flies!"


def test_observer(capsys):
    subj = load("e2_observer_subject")
    obs = importlib.reload(load("e2_observer_observers"))
    assert "Breaking: Lions" in capsys.readouterr().out
    assert obs.paper.results == [subj.GameResult("Lions", "Eagles", "2-1")]
    obs.hub.unregister(obs.radio)
    obs.hub.add_game_result(subj.GameResult("Eagles", "Lions", "1-0"))
    assert capsys.readouterr().out == "" and len(obs.paper.results) == 2


def test_command():
    m = load("e3_command_invoker"); p = load("e3_command_parts")
    assert m.doc.text == "Patterns"
    doc, ed = p.Document("Patterns"), m.Editor()
    ed.run(p.AddText(doc, " are fun")); assert doc.text == "Patterns are fun"
    ed.run(p.AddText(doc, "!"));        assert doc.text == "Patterns are fun!"
    ed.undo(); ed.undo();               assert doc.text == "Patterns"


def test_template_method(capsys):
    m = load("e4b_template_store"); importlib.reload(m)
    assert capsys.readouterr().out.split("\n")[:5] == [
        "1 large, thin crust", "paid", "hand-tossed dough", "deck oven, 6 min", "delivered"]
    assert m.NewYorkStylePizzaStore().create_pizza_for_delivery() == [
        "1 large, thin crust", "paid", "hand-tossed dough", "deck oven, 6 min", "delivered"]
    with pytest.raises(TypeError):
        load("e4a_template_skeleton").PizzaStore()


def test_pythonic_shortcuts():
    m = load("f1_pythonic")
    assert m.Hero(m.fly).do_hero_stuff() == "Up, Up, and Away!"
    assert m.Hero().do_hero_stuff() == "Run away"
    assert m.log == ["a", "b"]

    class Obs: pass
    s, o = m.Subject(), Obs()
    s.observers.add(o)
    assert len(s.observers) == 1
    del o; gc.collect()
    assert len(s.observers) == 0
