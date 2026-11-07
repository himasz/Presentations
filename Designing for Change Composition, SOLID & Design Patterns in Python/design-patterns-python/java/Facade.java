//-
class Confusing { int execute(int a, int b, int c) { return a + b + c; } }
class Overdone {
    Overdone(String s) {}
    int doSomething(int x, int y) { return x * y; }
    int doSomethingElse(int x, int y, int z) { return (x + y) * z; }
    int doSomethingAgain(int x, int y, int z, int a) { return (x + y + z) * a; } }
//+
class BetterApi {                   // the facade
    private final Confusing c = new Confusing();
    private final Overdone o = new Overdone("foo");

    int addThreeNumbers(int a, int b, int x) {
        return c.execute(a, b, x);
    }
    // Java has real overloads, like the repo's C#:
    int addThenMultiply(int a, int f) {
        return o.doSomething(a, f);
    }
    int addThenMultiply(int a, int b, int f) {
        return o.doSomethingElse(a, b, f);
    }
    int addThenMultiply(int x, int y, int z, int f) {
        return o.doSomethingAgain(x, y, z, f);
    }
}
//-
class Main { public static void main(String[] a) {
var api = new BetterApi();
if (api.addThreeNumbers(1, 2, 3) != 6 || api.addThenMultiply(4, 5) != 20 || api.addThenMultiply(4, 3, 5) != 35 || api.addThenMultiply(4, 3, 2, 5) != 45) throw new AssertionError();
}}
