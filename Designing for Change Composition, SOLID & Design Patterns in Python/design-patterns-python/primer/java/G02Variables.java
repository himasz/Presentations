//-
class Main { public static void main(String[] args) {
//+
int count = 3;            // the type is declared
// count = "three";       compile error
var price = 9.5;          // var: inferred double
final double DISCOUNT = 0.9;   // really constant

int a = 1, b = 2;
int tmp = a; a = b; b = tmp;   // no tuple swap
int drive, attack, defend;
drive = attack = defend = 100;

String nothing = null;
boolean done = true;

System.out.println(a + " " + b + " " + drive);
//> 2 1 100
System.out.println(7 / 2 + " " + 7.0 / 2);
//> 3 3.5
//-
}}
