//-
import java.util.*;
import java.nio.file.*;
import java.io.IOException;
record Order(double price) {}
//+
record SalesReport(List<Order> orders) { // finance
    double total() {
        return orders.stream()
            .mapToDouble(Order::price).sum();
    }
}
class HtmlFormatter {                  // design team
    String format(SalesReport r) {
        return "<h1>%.2f</h1>".formatted(r.total());
    }
}

class FileStore {                  // ops / storage
    void save(Path p, String text)
            throws IOException {
        Files.writeString(p, text);
    }
}
//-
class Main { public static void main(String[] a) throws Exception {
Locale.setDefault(Locale.ROOT);
String h = new HtmlFormatter().format(new SalesReport(List.of(new Order(10), new Order(5.5))));
if (!h.equals("<h1>15.50</h1>")) throw new AssertionError(h);
Path p = Files.createTempFile("r", ".html"); new FileStore().save(p, h);
if (!Files.readString(p).equals(h)) throw new AssertionError();
}}
