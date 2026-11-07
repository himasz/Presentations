//-
import java.util.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
class Moose { int run() { return 5; } int charge() { return 10; } }
class MooseAdapter { private final Moose m; MooseAdapter(Moose m) { this.m = m; } int chase() { return m.run(); } }
//+
// JUnit 5: org.junit.jupiter.api.*
class DemoTest {
    @Test void adapter() {
        var a = new MooseAdapter(new Moose());
        assertEquals(5, a.chase());
    }
    @Test void missingIndexThrows() {
        assertThrows(IndexOutOfBoundsException.class,
            () -> List.of().get(0));
    }
    @ParameterizedTest
    @CsvSource({"2, 4", "3, 9"})
    void square(int n, int sq) {
        assertEquals(sq, n * n);
    }
}
// $ mvn test   ->  Tests run: 4, Failures: 0
//-
class Main { public static void main(String[] args) {
var t = new DemoTest(); t.adapter(); t.missingIndexThrows(); t.square(2, 4); t.square(3, 9);
}}
