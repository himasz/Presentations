//-
import java.util.*;
//+
interface Combatant { int chase(); int attack(); }
interface Escaper extends Combatant { int flee(); }

class BadGuyAdapter implements Combatant { // no flee
    private final BadGuy g;
    BadGuyAdapter(BadGuy g) { this.g = g; }
    public int chase()  { return g.drive(); }
    public int attack() { return g.shoot(); }
}
//-
class Game {
//+

static int retreat(List<Escaper> party) {
    return party.stream()
        .mapToInt(Escaper::flee).sum();
}
//-
static void demo() {
//+

// retreat(List.of(new BadGuyAdapter(new BadGuy())));
//   -> javac error: incompatible types
//-
//? retreat(List.of(new BadGuyAdapter(new BadGuy())));
var b = new BadGuyAdapter(new BadGuy()); if (b.chase() != 30 || b.attack() != 50) throw new AssertionError();
}
}
class Main { public static void main(String[] a) { Game.demo(); }}
