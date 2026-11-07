//-
import java.util.*;
//+
interface Escaper {
    int chase();
    int flee();
}
class BadGuyAdapter {                // no flee()
    public int chase() { return 30; }
}
//-
class Main {
//+
static int retreat(List<Escaper> party) {
    return party.stream()
        .mapToInt(Escaper::flee).sum();
}
//-
public static void main(String[] args) {
//+

//? retreat(List.of(new BadGuyAdapter()));
// $ javac Retreat.java
//! error: incompatible types
//-
}}
