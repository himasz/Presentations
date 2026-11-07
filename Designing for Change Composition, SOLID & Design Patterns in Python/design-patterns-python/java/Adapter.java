interface GameCharacter { // what the game wants
    int chase(); int flee(); int attack();
}
class Moose {             // what we actually have
    int run() { return 5; }
    int charge() { return 10; }
}
class MooseAdapter implements GameCharacter {
    private final Moose m;
    MooseAdapter(Moose m) { this.m = m; }
    public int chase()  { return m.run(); }
    public int flee()   { return m.run(); }
    public int attack() { return m.charge(); }
}
//-
class Main { public static void main(String[] a) {
//+

GameCharacter c = new MooseAdapter(new Moose());
// c.chase(), c.flee(), c.attack()  -> 5, 5, 10
//-
if (c.chase() != 5 || c.flee() != 5 || c.attack() != 10) throw new AssertionError();
}}
