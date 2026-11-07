//-
import java.util.*;
//+
class Stack<T> {                   // HAS-A a deque
    private final Deque<T> items =
        new ArrayDeque<>();
    void push(T item) { items.push(item); }
    T pop() { return items.pop(); }
    int size() { return items.size(); }
}
//-
class Main { public static void main(String[] a) {
//+
// in main():
var s = new Stack<Integer>();
s.push(1);
// s.add(0, 99);  -> compile error. Good!
//-
s.push(2); if (s.pop() != 2 || s.size() != 1) throw new AssertionError();
}}
