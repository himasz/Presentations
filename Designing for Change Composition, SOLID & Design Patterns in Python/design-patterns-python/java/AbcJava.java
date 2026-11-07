abstract class SuperPower {
    abstract String exercisePower();
}

class Fly extends SuperPower {       // must extend
    String exercisePower() {
        return "Up, Up, and Away!";
    }
}
//-
class Main { public static void main(String[] a) {
//+

SuperPower power = new Fly();
// new SuperPower()  -> compile error
// A subclass that forgets exercisePower()
//   -> compile error too
//-
if (!power.exercisePower().equals("Up, Up, and Away!")) throw new AssertionError();
}}
