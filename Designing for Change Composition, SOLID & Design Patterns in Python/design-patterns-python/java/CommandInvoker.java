//-
import java.util.*;
interface Command { void execute(); void undo(); }
class Document { String text; Document(String t) { text = t; } }
class AddText implements Command {
    private final Document doc; private final String text;
    AddText(Document d, String t) { doc = d; text = t; }
    public void execute() { doc.text += text; }
    public void undo() { doc.text = doc.text.substring(0, doc.text.length() - text.length()); } }
//+
class Editor {                       // the invoker
    private final Deque<Command> history =
        new ArrayDeque<>();
    void run(Command cmd) {
        cmd.execute();
        history.push(cmd);
    }
    void undo() { history.pop().undo(); }
}
//-
class Main { public static void main(String[] a) {
//+

var doc = new Document("Patterns");
var editor = new Editor();
editor.run(new AddText(doc, " are fun"));
// doc.text -> "Patterns are fun"
editor.undo();
// doc.text -> "Patterns"
//-
if (!doc.text.equals("Patterns")) throw new AssertionError();
}}
