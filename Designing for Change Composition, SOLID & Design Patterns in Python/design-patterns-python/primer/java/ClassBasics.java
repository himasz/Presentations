class Hero {
    private final String power;

    Hero(String power) {
        this.power = power;
    }

    String act() {
        return "I can " + power;
    }
}
//-
class Main { public static void main(String[] a) {
//+

        Hero h = new Hero("fly");
        System.out.println(h.act());
//-
}}
