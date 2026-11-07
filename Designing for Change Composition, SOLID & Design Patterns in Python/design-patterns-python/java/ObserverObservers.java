//-
import java.util.*;
record GameResult(String winner, String loser, String score) {}
interface Observer { void update(GameResult r); }
class SportsAggregator {
    private final List<Observer> observers = new ArrayList<>();
    void register(Observer o) { observers.add(o); }
    void addGameResult(GameResult r) { for (Observer o : List.copyOf(observers)) o.update(r); } }
//+
class NewsPaper implements Observer {
    List<GameResult> results = new ArrayList<>();
    public void update(GameResult r) {
        results.add(r);
    }
}
class RadioStation implements Observer {
    public void update(GameResult r) {
        System.out.println(
            "Breaking: " + r.winner());
    }
}
//-
class Main { public static void main(String[] a) {
//+
var hub = new SportsAggregator();
var paper = new NewsPaper(); hub.register(paper);
hub.register(new RadioStation());
hub.addGameResult(
    new GameResult("Lions", "Eagles", "2-1"));
//> Breaking: Lions
//-
if (paper.results.size() != 1) throw new AssertionError();
}}
