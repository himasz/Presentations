//-
import java.nio.file.*;
import java.util.concurrent.locks.ReentrantLock;
class Main { public static void main(String[] args) throws Exception {
//+
// try-with-resources: closed even on an exception
try (var w = Files.newBufferedWriter(
        Path.of("report.html"))) {
    w.write("<h1>15.50</h1>");
}
System.out.println(
    Files.readString(Path.of("report.html")));
//> <h1>15.50</h1>

var lock = new ReentrantLock();
lock.lock();
try {
    System.out.println("one at a time");
} finally {
    lock.unlock();               // always release
}
//> one at a time
//-
Files.delete(Path.of("report.html"));
}}
