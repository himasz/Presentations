//-
interface Car { int drive(); int attack(); int defend(); }
record BaseCar() implements Car { public int drive() { return 100; } public int attack() { return 100; } public int defend() { return 100; } }
record ArmoredCar(Car car) implements Car { public int drive() { return car.drive() - 20; } public int attack() { return car.attack(); } public int defend() { return car.defend() + 40; } }
//+
record RaceCar(Car car) implements Car { // wraps too
    public int drive()  { return car.drive() + 40; }
    public int attack() { return car.attack() - 10; }
    public int defend() { return car.defend() - 10; }
}
//-
class Main { public static void main(String[] a) {
//+

// in main(): wrappers stack, read inside out
Car car = new RaceCar(new ArmoredCar(
    new ArmoredCar(new BaseCar())));
// car.drive(), car.attack(), car.defend()
// -> 100, 90, 170
//-
if (car.drive() != 100 || car.attack() != 90 || car.defend() != 170) throw new AssertionError();
}}
