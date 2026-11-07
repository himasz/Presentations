class Hero {
    String act() { return "Run away"; }
}
class FlyingHero extends Hero {
    String act() { return "Up, Up, and Away!"; }
}
class FightingHero extends Hero {
    String act() { return "KaBaam!"; }
}
// Needs both? Java won't even compile this:
//-
//? class FlyingFightingHero2 extends FlyingHero, FightingHero {}
//+
// class FlyingFightingHero
//     extends FlyingHero, FightingHero {}
// So you copy one behavior in by hand:
class FlyingFightingHero extends FlyingHero {
    // ...paste FightingHero's act() here?
}
//-
class Main { public static void main(String[] a) {
if (!new FlyingFightingHero().act().equals("Up, Up, and Away!")) throw new AssertionError();
}}
