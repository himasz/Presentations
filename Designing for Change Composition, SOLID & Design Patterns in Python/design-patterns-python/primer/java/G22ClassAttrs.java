class BaseCar {
    static int drive = 100;       // static = shared
}
class Counter {
    static int created = 0;       // shared by all
    int clicks = 0;               // per instance
    Counter() { created++; }
}
//-
class Main { public static void main(String[] args) {
//+

var a = new Counter(); var b = new Counter();
a.clicks++;
System.out.println(Counter.created + " " + a.clicks
    + " " + b.clicks);
//> 2 1 0
System.out.println(BaseCar.drive);           //> 100
// No shared-default trap: instance fields are
// initialised separately for every object.
//-
}}
