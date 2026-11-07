//-
import java.util.*;
class Main {
//+
static double checkout(double total, String kind) {
    if (kind.equals("student")) return total * 0.9;
    throw new IllegalArgumentException(
        "unknown kind: " + kind);
}
//-
public static void main(String[] args) {
//+

try {
    checkout(100, "alien");
} catch (IllegalArgumentException e) {
    System.out.println("Error: " + e.getMessage());
} finally {
    System.out.println("always runs");
}
//> Error: unknown kind: alien
//> always runs
// Map.get returns null instead of throwing:
System.out.println(Map.of("cheese", 8.0).get("x"));
//> null
//-
}}
