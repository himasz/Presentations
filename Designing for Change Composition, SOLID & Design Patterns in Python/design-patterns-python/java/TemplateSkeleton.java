//-
import java.util.*;
//+
abstract class PizzaStore {
    final List<String> createPizzaForDelivery() {
        return List.of(takeOrder(),  // the template
                       processPayment(),
                       makePizza(),
                       cookPizza(),
                       deliverPizza());
    }

    String processPayment() { return "paid"; }
    String deliverPizza() { return "delivered"; }

    abstract String takeOrder();
    abstract String makePizza();
    abstract String cookPizza();
}
//-
class Main { public static void main(String[] a) {
PizzaStore s = new PizzaStore() { String takeOrder() { return "o"; } String makePizza() { return "m"; } String cookPizza() { return "c"; } };
if (!s.createPizzaForDelivery().equals(List.of("o", "paid", "m", "c", "delivered"))) throw new AssertionError();
}}
