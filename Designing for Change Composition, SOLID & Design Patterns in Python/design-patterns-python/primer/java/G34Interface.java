interface SuperPower {
    String exercisePower();
}

class Fly implements SuperPower {  // must declare
    public String exercisePower() { return "Up!"; }
}

class Wing {                        // same shape...
    public String exercisePower() { return "Up!"; }
}
//-
class Main { public static void main(String[] args) {
//+

SuperPower p = new Fly();              // OK
System.out.println(p.exercisePower()); //> Up!
//? SuperPower w = new Wing();
//   -> compile error: Wing never said `implements`
//-
//! Wing cannot be converted to SuperPower
}}
