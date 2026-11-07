//-
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
record Order(double price) {}
//+
record SalesReport(List<Order> orders) {
    double total() {                   // finance
        return orders.stream()
            .mapToDouble(Order::price).sum();
    }
    String toHtml() {                  // design team
        return "<h1>%.2f</h1>".formatted(total());
    }
    void save(Path p) throws IOException { // ops
        Files.writeString(p, toHtml());
    }
}
//-
class Main { public static void main(String[] a) throws Exception {
Locale.setDefault(Locale.ROOT);
var r = new SalesReport(List.of(new Order(10), new Order(5.5)));
if (!r.toHtml().equals("<h1>15.50</h1>")) throw new AssertionError(r.toHtml());
Path p = Files.createTempFile("r", ".html"); r.save(p);
if (!Files.readString(p).equals("<h1>15.50</h1>")) throw new AssertionError();
}}
