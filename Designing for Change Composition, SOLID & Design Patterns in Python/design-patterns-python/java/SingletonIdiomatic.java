// Lazy holder: the JVM loads Holder on first use,
// and class loading is thread-safe.
final class Settings {
    int someValue = 0;
    private Settings() {}
    private static class Holder {
        static final Settings INSTANCE =
            new Settings();
    }
    static Settings get() { return Holder.INSTANCE; }
}

// Simplest of all (Effective Java, item 3):
enum Config { INSTANCE; int someValue = 0; }

// Settings.get() == Settings.get()
// Config.INSTANCE.someValue = 42;
//-
class Main { public static void main(String[] a) {
if (Settings.get() != Settings.get()) throw new AssertionError();
Config.INSTANCE.someValue = 42; if (Config.INSTANCE.someValue != 42) throw new AssertionError();
}}
