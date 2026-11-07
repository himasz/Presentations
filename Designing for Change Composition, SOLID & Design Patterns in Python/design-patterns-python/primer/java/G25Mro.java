interface Flying {
    default String act() {
        return "Up, Up, and Away!";
    }
}
interface Fighting {
    default String act() { return "KaBaam!"; }
}
// Same default twice? Java makes you choose.
class FlyingFightingHero
        implements Flying, Fighting {
    public String act() {               // required
        return Flying.super.act() + " "
             + Fighting.super.act();
    }
}
//-
//? class Broken implements Flying, Fighting {}
//! unrelated defaults
class Main { public static void main(String[] args) {
//+
System.out.println(new FlyingFightingHero().act());
//> Up, Up, and Away! KaBaam!
//-
}}
