class Greeter {
    String greet(String name) {
        if (name.isEmpty()) {
            return "Hello, stranger";
        }
        return "Hello, " + name;
    }
}
//-
class Main { public static void main(String[] a) {
//+

        Greeter g = new Greeter();
        System.out.println(g.greet("Ada"));
//-
}}
