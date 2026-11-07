//-
import java.util.*;
interface IngredientFactory { String dough(); String sauce(); String cheese(); }
class NewYorkIngredients implements IngredientFactory {
    public String dough() { return "thin crust"; } public String sauce() { return "marinara"; } public String cheese() { return "reggiano"; } }
class ChicagoIngredients implements IngredientFactory {
    public String dough() { return "deep dish"; } public String sauce() { return "plum tomato"; } public String cheese() { return "mozzarella"; } }
//+
class CheesePizza {
    private final IngredientFactory f;  // injected
    CheesePizza(IngredientFactory f) { this.f = f; }
    List<String> prepare() {        // matching set
        return List.of(f.dough(), f.sauce(),
                       f.cheese());
    }
}
//-
class Main { public static void main(String[] a) {
//+

// in main():
new CheesePizza(new ChicagoIngredients()).prepare();
// -> [deep dish, plum tomato, mozzarella]
new CheesePizza(new NewYorkIngredients()).prepare();
// -> [thin crust, marinara, reggiano]
//-
if (!new CheesePizza(new ChicagoIngredients()).prepare().equals(List.of("deep dish", "plum tomato", "mozzarella"))) throw new AssertionError();
if (!new CheesePizza(new NewYorkIngredients()).prepare().equals(List.of("thin crust", "marinara", "reggiano"))) throw new AssertionError();
}}
