//-
class BaseCar { int drive() { return 100; } }
//+
class ArmoredCar {
    private final BaseCar car;
    ArmoredCar(BaseCar car) { this.car = car; }
    int drive() { return car.drive() - 20; }
}
class Temperature {
    private double c = 0.0;
    double getCelsius() { return c; }
    void setCelsius(double value) {
        c = Math.max(value, -273.15);   // validate
    }
}
//-
class Main { public static void main(String[] args) {
//+

var car = new ArmoredCar(new BaseCar());
System.out.println(car.drive());     //> 80
var t = new Temperature();
t.setCelsius(-500);
System.out.println(t.getCelsius());  //> -273.15
//-
}}
