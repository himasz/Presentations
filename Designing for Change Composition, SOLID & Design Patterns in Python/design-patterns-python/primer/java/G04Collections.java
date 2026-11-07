//-
import java.util.*;
class Main { public static void main(String[] args) {
//+
List<String> powers = new ArrayList<>();
powers.add("fly"); powers.add("fight");
powers.add("swim");
String last = powers.removeLast();     // Java 21
System.out.println(powers + " " + last);
//> [fly, fight] swim
record Point(int x, int y) {}   // ~ a tuple
var point = new Point(3, 4);

Map<String, Double> prices = new HashMap<>();
prices.put("cheese", 8.0); prices.put("vip", 9.5);
System.out.println(prices.containsKey("vip"));
//> true
System.out.println(prices.get("hawaiian")); //> null

Set<String> seen = new HashSet<>(
    List.of("fly", "fly", "web"));
System.out.println(seen.size());            //> 2
//-
}}
