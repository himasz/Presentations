package org.junit.jupiter.api;
import org.junit.jupiter.api.function.Executable;
public final class Assertions {
    public static void assertEquals(int expected, int actual) { if (expected != actual) throw new AssertionError(expected + " != " + actual); }
    public static <T extends Throwable> T assertThrows(Class<T> type, Executable e) {
        try { e.execute(); } catch (Throwable t) { if (type.isInstance(t)) return type.cast(t); throw new AssertionError("wrong exception " + t); }
        throw new AssertionError("nothing thrown");
    }
}
