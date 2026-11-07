//-
import java.util.*;
//+
class Stack {
    private final List<Object> items =
        new ArrayList<>();
    void push(Object item) { items.add(item); }
    int size() { return items.size(); }   // len()
    @Override public String toString() {  // __repr__
        return "Stack(" + items + ")";
    }
    @Override public boolean equals(Object o) { // ==
        return o instanceof Stack s
            && items.equals(s.items);
    }
}
//-
class Main { public static void main(String[] args) {
//+
var s = new Stack(); s.push(1);
System.out.println(s.size() + " " + s);
//> 1 Stack([1])
System.out.println(s.equals(new Stack())); //> false
//-
}}
