abstract class PizzaStore {
    String order() {
        return "ordered " + create();
    }
    abstract String create();
}

class NYStore extends PizzaStore {
    @Override
    String create() { return "thin crust"; }
}
// new PizzaStore()  -> compile error
//-
class Main { public static void main(String[] a) {
    System.out.println(new NYStore().order());
}}
