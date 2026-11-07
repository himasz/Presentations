interface Car {
    int drive(); int attack(); int defend();
}
record BaseCar() implements Car {
    public int drive()  { return 100; }
    public int attack() { return 100; }
    public int defend() { return 100; }
}
record ArmoredCar(Car car) implements Car { // wraps
    public int drive()  { return car.drive() - 20; }
    public int attack() { return car.attack(); }
    public int defend() { return car.defend() + 40; }
}
//-
class Main { public static void main(String[] a) {
//+

// in main():
Car armored = new ArmoredCar(new BaseCar());
// armored.drive(), armored.defend()  -> 80, 140
//-
if (armored.drive() != 80 || armored.defend() != 140 || armored.attack() != 100) throw new AssertionError();
}}
