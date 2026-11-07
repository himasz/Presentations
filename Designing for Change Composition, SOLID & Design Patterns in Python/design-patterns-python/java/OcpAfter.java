interface Discount {
    double apply(double total);

    // one implementation per rule (lambdas here)
    Discount REGULAR = t -> t;
    Discount STUDENT = t -> t * 0.9;
    Discount VIP     = t -> t * 0.8 - 5;
}
//-
class Shop {
//+

static double checkout(double total, Discount d) {
    return d.apply(total);      // never edited again
}
//-
static void demo() {
//+

// New customer type?  -> add a Discount
checkout(100, Discount.STUDENT);   // 90.0
//-
if (checkout(100, Discount.STUDENT) != 90.0 || checkout(100, Discount.VIP) != 75.0 || checkout(100, Discount.REGULAR) != 100) throw new AssertionError();
}
}
class Main { public static void main(String[] a) { Shop.demo(); }}
