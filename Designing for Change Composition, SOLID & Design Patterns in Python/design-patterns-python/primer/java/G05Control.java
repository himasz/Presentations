//-
import java.util.*;
class Main {
//+
static String describe(int n) {
    if (n < 0) {
        return "negative";
    } else if (n == 0) {
        return "zero";
    } else {
        return "positive";
    }
}
//-
public static void main(String[] args) {
//+
System.out.println(describe(-5) + " " + describe(0));
//> negative zero
var words = List.of("a", "b");
for (int i = 0; i < words.size(); i++) {
    System.out.println(i + " " + words.get(i));
}
//> 0 a
//> 1 b
boolean ok = 0 < 5 && 5 < 10 && !false;  // no chains
//-
}}
