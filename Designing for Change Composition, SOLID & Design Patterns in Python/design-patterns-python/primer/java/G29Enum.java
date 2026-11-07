//-
import java.util.*;
//+
enum PizzaType {
    CHEESE("cheese"),
    PEPPERONI("pepperoni"),
    SAUSAGE("sausage");

    final String value;
    PizzaType(String value) { this.value = value; }
}
//-
class Main { public static void main(String[] args) {
//+

var kind = PizzaType.CHEESE;
System.out.println(kind);                 //> CHEESE
System.out.println(kind.value + " " + kind.name());
//> cheese CHEESE
System.out.println(PizzaType.valueOf("SAUSAGE"));
//> SAUSAGE
System.out.println(List.of(PizzaType.values()));
//> [CHEESE, PEPPERONI, SAUSAGE]
//-
}}
