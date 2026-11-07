final class Settings {
    private static volatile Settings instance;
    int someValue = 0;

    private Settings() {}

    static Settings getInstance() {
        if (instance == null) {          // fast path
            synchronized (Settings.class) {
                if (instance == null) {  // again
                    instance = new Settings();
                }
            }
        }
        return instance;
    }
}
// Settings.getInstance() == Settings.getInstance()
//-
class Main { public static void main(String[] a) throws Exception {
var seen = java.util.Collections.synchronizedList(new java.util.ArrayList<Settings>());
var ts = new java.util.ArrayList<Thread>();
for (int i = 0; i < 50; i++) { Thread t = new Thread(() -> seen.add(Settings.getInstance())); ts.add(t); t.start(); }
for (Thread t : ts) t.join();
for (Settings s : seen) if (s != seen.get(0)) throw new AssertionError();
}}
