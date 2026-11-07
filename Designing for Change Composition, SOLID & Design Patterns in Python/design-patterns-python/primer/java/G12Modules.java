// A class lives in a package, which is a folder:
//   com/example/pizza/PizzaType.java
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.*;      // a whole package
import static java.lang.Math.max; // one static name

class Registry {
    // A static initializer runs once, when the
    // JVM first loads the class.
    static { System.out.println("loaded once"); }
}
//> loaded once

// The entry point is always:
//   public static void main(String[] args)
//-
class Main { public static void main(String[] args) {
new Registry(); new Registry();
}}
