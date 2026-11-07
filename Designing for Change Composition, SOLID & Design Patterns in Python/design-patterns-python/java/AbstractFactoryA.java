interface IngredientFactory {       // one family
    String dough();
    String sauce();
    String cheese();
}
class NewYorkIngredients
        implements IngredientFactory {
    public String dough()  { return "thin crust"; }
    public String sauce()  { return "marinara"; }
    public String cheese() { return "reggiano"; }
}
class ChicagoIngredients
        implements IngredientFactory {
    public String dough()  { return "deep dish"; }
    public String sauce()  { return "plum tomato"; }
    public String cheese() { return "mozzarella"; }
}
//-
class Main { public static void main(String[] a) {
if (!new ChicagoIngredients().sauce().equals("plum tomato")) throw new AssertionError();
}}
