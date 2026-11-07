class Confusing {               // awkward, as found
    int execute(int a, int b, int c) {
        return a + b + c; }
    int method1() { return 0; }
    int method2(int x, int y) { return x + y; }
}
class Overdone {
    Overdone(String someString) {}
    int doSomething(int x, int y) { return x * y; }
    int doSomethingElse(int x, int y, int z) {
        return (x + y) * z;
    }
    int doSomethingAgain(int x, int y, int z,
                         int a) {
        return (x + y + z) * a;
    }
}
//-
class Main { public static void main(String[] a) {
if (new Overdone("x").doSomethingAgain(4, 3, 2, 5) != 45) throw new AssertionError();
}}
