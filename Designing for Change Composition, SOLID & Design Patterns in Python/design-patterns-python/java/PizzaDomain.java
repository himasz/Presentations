import java.util.*;
enum PizzaType { CHEESE, PEPPERONI, SAUSAGE }
class Pizza {
    final PizzaType kind; final String dough;
    final List<String> steps = new ArrayList<>();
    Pizza(PizzaType kind, String dough) { this.kind = kind; this.dough = dough; }
    Pizza(PizzaType kind) { this(kind, "regular"); }
    void prepare() { steps.add("prepare"); }
    void bake() { steps.add("bake"); }
    void cut() { steps.add("cut"); }
    void box() { steps.add("box"); }
}
class CheesePizza extends Pizza { CheesePizza() { super(PizzaType.CHEESE); } }
class PepperoniPizza extends Pizza { PepperoniPizza() { super(PizzaType.PEPPERONI); } }
class SausagePizza extends Pizza { SausagePizza() { super(PizzaType.SAUSAGE); } }
