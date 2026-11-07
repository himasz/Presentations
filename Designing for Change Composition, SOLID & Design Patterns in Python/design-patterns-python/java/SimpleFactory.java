//-
import java.util.*;
import java.util.function.Supplier;
//+
class SimplePizzaFactory {
    static final Map<PizzaType, Supplier<Pizza>>
        REGISTRY = Map.of(
            PizzaType.CHEESE, CheesePizza::new,
            PizzaType.PEPPERONI, PepperoniPizza::new,
            PizzaType.SAUSAGE, SausagePizza::new);

    Pizza createPizza(PizzaType kind) {
        return REGISTRY.get(kind).get();
    }   // a missing key -> NullPointerException
}
//-
class Main { public static void main(String[] a) {
//+

// in main(): CheesePizza::new is a constructor
// reference, Java's "class as a callable"
var factory = new SimplePizzaFactory();
var pizza = factory.createPizza(PizzaType.CHEESE);
//-
if (!(pizza instanceof CheesePizza)) throw new AssertionError();
for (PizzaType t : PizzaType.values()) if (factory.createPizza(t).kind != t) throw new AssertionError();
}}
