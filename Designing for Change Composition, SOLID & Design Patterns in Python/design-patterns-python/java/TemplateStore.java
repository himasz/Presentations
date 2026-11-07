//-
import java.util.*;
abstract class PizzaStore {
    final List<String> createPizzaForDelivery() { return List.of(takeOrder(), processPayment(), makePizza(), cookPizza(), deliverPizza()); }
    String processPayment() { return "paid"; } String deliverPizza() { return "delivered"; }
    abstract String takeOrder(); abstract String makePizza(); abstract String cookPizza(); }
//+
class NewYorkStylePizzaStore extends PizzaStore {
    String takeOrder() {
        return "1 large, thin crust";
    }
    String makePizza() {
        return "hand-tossed dough";
    }
    String cookPizza() {
        return "deck oven, 6 min";
    }
}
//-
class Main { public static void main(String[] a) {
//+
var store = new NewYorkStylePizzaStore();
for (String step : store.createPizzaForDelivery())
    System.out.println(step);
// -> 1 large, thin crust | paid | hand-tossed
//    dough | deck oven, 6 min | delivered
//-
var out = new NewYorkStylePizzaStore().createPizzaForDelivery();
if (!out.equals(List.of("1 large, thin crust", "paid", "hand-tossed dough", "deck oven, 6 min", "delivered"))) throw new AssertionError();
}}
