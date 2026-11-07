//-
import java.util.*;
//+
record GameResult(String winner, String loser,
                  String score) {}  // immutable

record Pizza(String kind, String dough,
             List<String> steps) {
    Pizza(String kind) {            // a "default"
        this(kind, "regular", new ArrayList<>());
    }
}
//-
class Main { public static void main(String[] args) {
//+
var r = new GameResult("Ox", "Elk", "2-1");
System.out.println(r);
//> GameResult[winner=Ox, loser=Elk, score=2-1]
var same = new GameResult("Ox", "Elk", "2-1");
System.out.println(r.equals(same));        //> true
System.out.println(new Pizza("cheese"));
//> Pizza[kind=cheese, dough=regular, steps=[]]
//-
}}
