# Designing for Change: companion code

Every code block in the lecture deck "Designing for Change: Composition, SOLID & Design Patterns", in Python and in Java.
The examples are ports of the C# samples in
[himasz/design-patterns-c-sharp](https://github.com/himasz/design-patterns-c-sharp) (samples by Philip Japikse, MIT licence).

## Python (3.10+)

```bash
pip install pytest mypy
pytest -q          # 27 tests
mypy *.py          # all examples type-check
```

Where a file has a `# --- slide ---` line, only the code below it is on the slide; the lines above are imports.

## Java (21+)

The `java/` folder has the Java twin of every Python example. Each file compiles and runs on its own:

```bash
cd java
javac -d out SimpleFactory.java PizzaDomain.java && java -cp out Main
```

`SimpleFactory.java` and `FactoryMethod.java` need `PizzaDomain.java`; `LspBefore.java` and `LspAfter.java` need `GameDomain.java`.
Lines between `//-` and `//+` are hidden on the slide (imports, `main`, and checks that throw if the example misbehaves).
A line starting with `//?` is code that does not compile on purpose; remove the `//? ` to see the compiler error.

| Slide | Python | Java |
|---|---|---|
| Interfaces, part 1: ABC | `i1_abc.py` | `AbcJava.java` |
| Interfaces, part 2: Protocol | `i1_protocol.py` | `InterfaceJava.java` |
| The inheritance trap | `a1_inheritance_trap.py` | `InheritanceTrap.java` |
| The same heroes, composed | `a2_composition.py` | `Composition.java` |
| Inheritance exposes everything | `a3_stack_inherit.py` | `StackInherit.java` |
| Composition shows only what it means | `a3_stack_compose.py` | `StackCompose.java` |
| S, before / after | `b1_srp_before.py`, `b1_srp_after.py` | `SrpBefore.java`, `SrpAfter.java` |
| O, before / after | `b2_ocp_*.py` | `OcpBefore.java`, `OcpAfter.java` |
| L, before / after | `b3_lsp_*.py` | `LspBefore.java`, `LspAfter.java` |
| I, before / after | `b4_isp_*.py` | `IspBefore.java`, `IspAfter.java` |
| D, before / after | `b5_dip_*.py` | `DipBefore.java`, `DipAfter.java` |
| Singleton (2 slides) | `c1_singleton_classic.py`, `c1_singleton_pythonic.py` | `SingletonClassic.java`, `SingletonIdiomatic.java` |
| Simple Factory | `c2_simple_factory.py` | `SimpleFactory.java` |
| Factory Method | `c3_factory_method.py` | `FactoryMethod.java` |
| Abstract Factory (2 slides) | `c4a_abstract_factory.py`, `c4b_abstract_factory_client.py` | `AbstractFactoryA.java`, `AbstractFactoryB.java` |
| Adapter | `d1_adapter.py` | `Adapter.java` |
| Decorator (2 slides) | `d2a_decorator.py`, `d2b_decorator_stack.py` | `DecoratorA.java`, `DecoratorB.java` |
| Facade (2 slides) | `d3_facade_subsystem.py`, `d3_facade.py` | `FacadeSubsystem.java`, `Facade.java` |
| Strategy (2 slides) | `e1a_strategy_powers.py`, `e1b_strategy_hero.py` | `StrategyPowers.java`, `StrategyHero.java` |
| Observer (2 slides) | `e2_observer_subject.py`, `e2_observer_observers.py` | `ObserverSubject.java`, `ObserverObservers.java` |
| Command (2 slides) | `e3_command_parts.py`, `e3_command_invoker.py` | `CommandParts.java`, `CommandInvoker.java` |
| Template Method (2 slides) | `e4a_template_skeleton.py`, `e4b_template_store.py` | `TemplateSkeleton.java`, `TemplateStore.java` |
| When the language makes a pattern disappear | `f1_pythonic.py` | (on the slide) |

`pizza.py` and `characters.py` are shared Python domain classes. The `primer/` folder holds the examples from the presenter's guide ("Python for the Lecture").

## Lab

1. **Decorator**: add a `ShieldCar` (+60 defend, −30 drive) and stack it on a `RaceCar`.
2. **Strategy**: let a hero hold several powers (see `a2_composition.py`), and give SpiderMan `Fly` too.
3. **Adapter**: write a `DragonAdapter` so a `Dragon(glide, breathe_fire)` can join the game as a `Character`.
4. **Observer**: make `register()` return an unsubscribe function, then test it.
5. **Command**: add an `AddNumber` command and a `redo()` method on `Editor`.
6. **DIP**: write a test for `OrderService` using `InMemoryRepo`: no database.

Work in either language. In Python, `pytest -q` stays green after every exercise, and each exercise adds a test.
