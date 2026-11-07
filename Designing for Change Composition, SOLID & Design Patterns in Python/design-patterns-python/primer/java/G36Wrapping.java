//-
import java.util.function.*;
class Main {
//+
// No decorators. The closest: a function that
// takes a function and returns a new one.
static <T, R> Function<T, R> logCalls(
        String name, Function<T, R> func) {
    return arg -> {
        System.out.println("calling " + name);
        return func.apply(arg);
    };
}
//-
public static void main(String[] args) {
//+

Function<String, String> greet =
    logCalls("greet", n -> "Hi " + n);
System.out.println(greet.apply("Ada"));
//> calling greet
//> Hi Ada
// @Override or @Test look alike, but annotations
// only label code. They don't wrap it.
//-
}}
