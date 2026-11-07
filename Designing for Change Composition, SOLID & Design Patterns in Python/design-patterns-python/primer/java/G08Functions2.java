//-
import java.util.function.*;
import java.util.stream.*;
class Main {
//+
static int addThenMultiply(int factor, int... nums) {
    return IntStream.of(nums).sum() * factor;
}   // varargs must come last, so factor goes first
static String fly() { return "Up, Up, and Away!"; }
//-
public static void main(String[] args) {
//+

System.out.println(addThenMultiply(5, 4, 3)); //> 35
int[] pair = {4, 3};
System.out.println(addThenMultiply(2, pair)); //> 14

Supplier<String> power = Main::fly;  // method ref
Supplier<String> shout = () -> "KaBaam!"; // lambda
System.out.println(power.get());
//> Up, Up, and Away!
System.out.println(shout.get());        //> KaBaam!
//-
}}
