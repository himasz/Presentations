interface IngredientFactory {   // the repo's shape
    String makeDough();
    String makeSauce();
    String makeCheese();
    String makeSausage();
    String makePepperoni();
}

class VeggieKitchen implements IngredientFactory {
    // makeDough / makeSauce / makeCheese ...
//-
    public String makeDough() { return "wheat"; }
    public String makeSauce() { return "tomato"; }
    public String makeCheese() { return "vegan"; }
//+
    public String makeSausage() {      // forced to
        throw new UnsupportedOperationException();
    }
    public String makePepperoni() {    // forced to
        throw new UnsupportedOperationException();
    }
}
//-
class Main { public static void main(String[] a) {
try { new VeggieKitchen().makeSausage(); throw new AssertionError(); } catch (UnsupportedOperationException e) {}
}}
