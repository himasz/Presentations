//-
import java.util.*;
//+
interface BaseIngredients {
    String makeDough();
    String makeSauce();
    String makeCheese();
}
interface MeatIngredients {
    String makeSausage(); String makePepperoni();
}

class VeggieKitchen implements BaseIngredients {
    public String makeDough()  { return "wheat"; }
    public String makeSauce()  { return "tomato"; }
    public String makeCheese() { return "vegan"; }
}
//-
class Kitchen {
//+
static List<String> cheesePizza(BaseIngredients k) {
    return List.of(k.makeDough(), k.makeSauce(),
                   k.makeCheese());
}
//-
}
class Main { public static void main(String[] a) {
if (!Kitchen.cheesePizza(new VeggieKitchen()).equals(List.of("wheat", "tomato", "vegan"))) throw new AssertionError();
}}
