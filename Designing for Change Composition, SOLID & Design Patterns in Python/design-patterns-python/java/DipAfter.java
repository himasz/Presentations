//-
import java.util.*;
record Order(int id) {}
class PostgresRepo implements OrderRepository { public void save(Order o) {} }
//+
interface OrderRepository {          // abstraction
    void save(Order order);
}
class OrderService {
    private final OrderRepository repo;
    OrderService(OrderRepository repo) {
        this.repo = repo;            // injected
    }
    void place(Order order) { repo.save(order); }
}
class InMemoryRepo implements OrderRepository {
    final List<Order> rows = new ArrayList<>();
    public void save(Order o) { rows.add(o); }
}

// new OrderService(new InMemoryRepo())  in tests
// new OrderService(new PostgresRepo())  in prod
//-
class Main { public static void main(String[] a) {
var repo = new InMemoryRepo(); new OrderService(repo).place(new Order(1));
if (!repo.rows.equals(List.of(new Order(1)))) throw new AssertionError();
new OrderService(new PostgresRepo());
}}
