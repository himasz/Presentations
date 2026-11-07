//-
interface SuperPower { String exercisePower(); }
class Fly implements SuperPower { public String exercisePower() { return "Up, Up, and Away!"; } }
class WeaveWeb implements SuperPower { public String exercisePower() { return "Catches Thieves Like Flies!"; } }
//+
class Hero {
    private SuperPower power;
    Hero(SuperPower power) { this.power = power; }
    String doHeroStuff() {
        return power.exercisePower();
    }
    void changeSuperPower(SuperPower power) {
        this.power = power;     // swap at runtime
    }
}
class SpiderMan extends Hero {
    SpiderMan() { super(new WeaveWeb()); }
}
//-
class Main { public static void main(String[] a) {
//+

Hero spidey = new SpiderMan();
spidey.doHeroStuff(); // Catches Thieves Like Flies!
spidey.changeSuperPower(new Fly());
spidey.doHeroStuff(); // Up, Up, and Away!
//-
Hero s = new SpiderMan(); if (!s.doHeroStuff().equals("Catches Thieves Like Flies!")) throw new AssertionError();
s.changeSuperPower(new Fly()); if (!s.doHeroStuff().equals("Up, Up, and Away!")) throw new AssertionError();
}}
