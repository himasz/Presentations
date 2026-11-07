//-
import java.util.function.*;
class Pizza {}
class CheesePizza extends Pizza { public CheesePizza() {} }
class Main {
public static void main(String[] args) throws Exception {
//+
// Supplier<Pizza>: no arguments, returns a Pizza.
// A constructor reference fits.
Supplier<Pizza> make = CheesePizza::new;
System.out.println(
    make.get().getClass().getSimpleName());
//> CheesePizza
//-
if (!(build(CheesePizza.class) instanceof CheesePizza)) throw new AssertionError();
}
//+

// Class<? extends Pizza>: the class object itself.
static Pizza build(Class<? extends Pizza> cls)
        throws ReflectiveOperationException {
    return cls.getDeclaredConstructor()
              .newInstance();       // reflection!
}
//-
}
//+
// No forward references needed in Java:
class Settings { static Settings instance; }
