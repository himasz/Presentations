interface Command { void execute(); void undo(); }
class Document {                     // the receiver
    String text;
    Document(String text) { this.text = text; }
}

class AddText implements Command { // a request
    private final Document doc;
    private final String text;
    AddText(Document doc, String text) {
        this.doc = doc; this.text = text;
    }
    public void execute() { doc.text += text; }
    public void undo() {
        doc.text = doc.text.substring(
            0, doc.text.length() - text.length());
    }
}
//-
class Main { public static void main(String[] a) {
var d = new Document("Patterns"); var c = new AddText(d, " are fun"); c.execute();
if (!d.text.equals("Patterns are fun")) throw new AssertionError(); c.undo(); if (!d.text.equals("Patterns")) throw new AssertionError();
}}
