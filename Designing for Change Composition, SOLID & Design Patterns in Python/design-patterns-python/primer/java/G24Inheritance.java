class Hero {
    final String name;
    Hero(String name) { this.name = name; }
    String act() { return name + " runs away"; }
}
class FlyingHero extends Hero {
    final int speed;
    FlyingHero(String name, int speed) {
        super(name); this.speed = speed;
    }
    @Override String act() {
        return name + " flies at " + speed;
    }
}
//-
class Main { public static void main(String[] args) {
//+
Hero joe = new Hero("Joe");
Hero kara = new FlyingHero("Kara", 900);
System.out.println(joe.act());  //> Joe runs away
System.out.println(kara.act()); //> Kara flies at 900
//-
if (!(kara instanceof Hero)) throw new AssertionError();
}}
