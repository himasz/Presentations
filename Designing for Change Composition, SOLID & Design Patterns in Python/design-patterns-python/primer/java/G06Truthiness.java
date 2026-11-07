//-
import java.util.*;
class RegularJoe {}
class Main { public static void main(String[] args) {
//+
// No truthiness: an if needs a real boolean.
List<String> items = List.of();
if (items.isEmpty()) {        // `if (items)`: error
    System.out.println("empty");
}
//> empty
RegularJoe power = null;
power = power != null ? power : new RegularJoe();
System.out.println(power.getClass().getSimpleName());
//> RegularJoe

Integer count = 0;
System.out.println(count != null ? count : 10);
//> 0

var a = List.of(1); var b = List.of(1);
System.out.println(a.equals(b) + " " + (a == b));
//> true false
//-
}}
