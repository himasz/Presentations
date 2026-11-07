//-
import java.util.*;
//+
interface GameCharacter {
    int chase(); int flee(); int attack();
}
class BadGuyAdapter implements GameCharacter {
    private final BadGuy g;
    BadGuyAdapter(BadGuy g) { this.g = g; }
    public int chase()  { return g.drive(); }
    public int attack() { return g.shoot(); }
    public int flee() {
        throw new UnsupportedOperationException(
            "Bad guys don't flee!");
    }
}
//-
class Game {
//+
static int retreat(List<GameCharacter> party) {
    return party.stream()
        .mapToInt(GameCharacter::flee).sum(); // boom
}
//-
}
class Main { public static void main(String[] a) {
try { Game.retreat(List.of(new BadGuyAdapter(new BadGuy()))); throw new AssertionError(); }
catch (UnsupportedOperationException e) { if (!e.getMessage().equals("Bad guys don't flee!")) throw new AssertionError(); }
}}
