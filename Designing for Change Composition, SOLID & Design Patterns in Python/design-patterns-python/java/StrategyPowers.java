interface SuperPower {
    String exercisePower();
}

class Fly implements SuperPower {
    public String exercisePower() {
        return "Up, Up, and Away!";
    }
}

class WeaveWeb implements SuperPower {
    public String exercisePower() {
        return "Catches Thieves Like Flies!";
    }
}
//-
class Main { public static void main(String[] a) {
//+

// A one-method interface also takes a lambda:
SuperPower fight = () -> "KaBaam!";
//-
if (!fight.exercisePower().equals("KaBaam!")) throw new AssertionError();
}}
