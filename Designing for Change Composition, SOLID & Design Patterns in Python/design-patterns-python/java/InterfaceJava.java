interface SuperPower {
    String exercisePower();
}

class Fly implements SuperPower {  // must say so
    public String exercisePower() {
        return "Up, Up, and Away!";
    }
}
//-
class Main { public static void main(String[] a) {
//+

SuperPower power = new Fly();
// Java interfaces are nominal: a class that has
// the method but no `implements` does NOT fit.
// Nothing in Java matches Protocol's duck typing.
//-
if (!power.exercisePower().equals("Up, Up, and Away!")) throw new AssertionError();
}}
