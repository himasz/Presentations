//-
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.*;
class Main { public static void main(String[] args) {
//+
var prices = List.of(8.0, 9.5, 10.0);
var doubled = prices.stream()
    .map(p -> p * 2).toList();
var cheap = prices.stream()
    .filter(p -> p < 10).toList();
var sizes = Stream.of("fly", "web")
    .collect(toMap(w -> w, String::length));
System.out.println(doubled);  //> [16.0, 19.0, 20.0]
System.out.println(cheap);    //> [8.0, 9.5]
System.out.println(sizes);    //> {fly=3, web=3}

double total = prices.stream()
    .mapToDouble(p -> p).sum();
System.out.println(total);    //> 27.5
System.out.println(Stream.of("up", "away")
    .map(String::toUpperCase)
    .collect(joining(" / ")));
//> UP / AWAY
//-
}}
