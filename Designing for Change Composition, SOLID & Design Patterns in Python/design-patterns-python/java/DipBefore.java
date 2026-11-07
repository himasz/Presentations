//-
record Order(int id) {}
//+
class PostgresRepo {
    void save(Order order) {
        // INSERT INTO orders ...
    }
}

class OrderService {             // high-level policy
    private final PostgresRepo repo =
        new PostgresRepo();      // hard-wired
    void place(Order order) { repo.save(order); }
}

// Testing place() now needs a real database,
// and switching storage means editing the
// business logic.
//-
class Main { public static void main(String[] a) { new OrderService().place(new Order(1)); }}
