//-
import java.util.*;
class Main {
//+
static int add(int a, int b) {
    return a + b;
}
//-
public static void main(String[] args) {
//+

System.out.println(add(2, 3));             //> 5
//? System.out.println(add("2", "3"));
//   $ javac Hints.java   (it never runs)
//! String cannot be converted to int

String name = "Ada";
String maybe = null;     // any reference may be null
Optional<String> opt = Optional.empty();  // explicit
List<String> names = List.of("Ada");
Map<String, Integer> ages = Map.of("Ada", 36);
//-
}}
