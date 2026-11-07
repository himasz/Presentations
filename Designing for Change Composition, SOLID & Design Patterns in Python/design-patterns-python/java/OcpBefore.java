//-
class Shop {
//+
static double checkout(double total, String kind) {
    if (kind.equals("regular")) {
        return total;
    } else if (kind.equals("student")) {
        return total * 0.9;
    } else if (kind.equals("vip")) {
        return total * 0.8 - 5;
    }
    throw new IllegalArgumentException(kind);
}

// New customer type?
//   -> edit, re-test, re-deploy checkout()
//-
}
class Main { public static void main(String[] a) {
if (Shop.checkout(100, "student") != 90.0 || Shop.checkout(100, "vip") != 75.0) throw new AssertionError();
}}
