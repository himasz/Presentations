abstract class PizzaStore {
    Pizza orderPizza(PizzaType kind) {
        var p = createPizza(kind); // factory method
        p.prepare(); p.bake(); p.cut(); p.box();
        return p;
    }
    abstract Pizza createPizza(PizzaType kind);
}
class NewYorkStore extends PizzaStore {
    Pizza createPizza(PizzaType kind) {
        return new Pizza(kind, "thin");
    }
}
class ChicagoStore extends PizzaStore {
    Pizza createPizza(PizzaType kind) {
        return new Pizza(kind, "deep dish");
    }
}
//-
class Main { public static void main(String[] a) {
Pizza p = new ChicagoStore().orderPizza(PizzaType.SAUSAGE);
if (!p.dough.equals("deep dish") || !p.steps.equals(java.util.List.of("prepare", "bake", "cut", "box"))) throw new AssertionError();
if (!new NewYorkStore().orderPizza(PizzaType.CHEESE).dough.equals("thin")) throw new AssertionError();
}}
