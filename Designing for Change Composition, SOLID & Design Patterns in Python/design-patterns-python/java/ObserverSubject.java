//-
import java.util.*;
//+
record GameResult(String winner, String loser,
                  String score) {}    // immutable
interface Observer {
    void update(GameResult r);
}
class SportsAggregator {             // the subject
    private final List<Observer> observers =
        new ArrayList<>();
    void register(Observer o) { observers.add(o); }
    void unregister(Observer o) {
        observers.remove(o);
    }
    void addGameResult(GameResult r) {
        for (Observer o : List.copyOf(observers)) {
            o.update(r);         // push to everyone
        }
    }
}
//-
class Main { public static void main(String[] a) {
var hub = new SportsAggregator(); var got = new ArrayList<GameResult>();
Observer o = got::add; hub.register(o); hub.addGameResult(new GameResult("Lions", "Eagles", "2-1"));
hub.unregister(o); hub.addGameResult(new GameResult("Eagles", "Lions", "1-0"));
if (got.size() != 1) throw new AssertionError();
}}
