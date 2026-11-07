//-
import java.util.*;
class Main {
//+
static double area(double width, double height) {
    return width * height;
}
static double area(double width) {   // no defaults:
    return area(width, 1.0);         // overload it
}
// No named arguments: area(height=2, width=5)
// has no Java equivalent.

static void greet(String name) {     // void
    System.out.println("Hi " + name);
}

record MinMax(int lo, int hi) {}     // no tuples
static MinMax minMax(List<Integer> xs) {
    return new MinMax(Collections.min(xs),
                      Collections.max(xs));
}
//-
public static void main(String[] args) {
if (area(3) != 3.0 || area(3, 2) != 6.0) throw new AssertionError();
if (!minMax(List.of(3, 1, 4)).equals(new MinMax(1, 4))) throw new AssertionError();
}}
