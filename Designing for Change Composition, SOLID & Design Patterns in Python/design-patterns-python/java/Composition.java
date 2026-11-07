//-
import java.util.*;
import java.util.stream.*;
//+
interface SuperPower { String exercise(); }

class Hero {
    private final List<SuperPower> powers;
    Hero(SuperPower... powers) {        // has-a
        this.powers = List.of(powers);
    }
    String act() {
        return powers.stream()
            .map(SuperPower::exercise)
            .collect(Collectors.joining(" / "));
    }
}
//-
class Main { public static void main(String[] a) {
//+
// in main(): a one-method interface takes a lambda
SuperPower fly = () -> "Up, Up, and Away!";
new Hero(fly, () -> "KaBaam!").act();
// -> "Up, Up, and Away! / KaBaam!"
//-
if (!new Hero(fly, () -> "KaBaam!").act().equals("Up, Up, and Away! / KaBaam!")) throw new AssertionError();
}}
