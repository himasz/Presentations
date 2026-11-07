//-
import java.util.*;
class Main { public static void main(String[] args) {
//+
String name = "Ada";           // only " for strings
String greeting = "Hi " + name + "!";
double total = 15.5;
System.out.println(greeting);             //> Hi Ada!
System.out.println("<h1>%.2f</h1>".formatted(total));
//> <h1>15.50</h1>

var parts = List.of("Up", "Up", "Away");
System.out.println(String.join(" / ", parts));
//> Up / Up / Away

String text = "Patterns are fun";
System.out.println(text.substring(0, 8));
//> Patterns
System.out.println(text.length());        //> 16
String doc = """
    Text block: a string
    that spans several lines.""";
//-
}}
