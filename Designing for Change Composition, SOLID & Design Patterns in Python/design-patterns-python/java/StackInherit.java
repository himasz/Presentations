//-
import java.util.*;
//+
class Stack<T> extends ArrayList<T> {   // IS-A list
    void push(T item) { add(item); }
}
//-
class Main { public static void main(String[] a) {
//+
// in main():
var s = new Stack<Integer>();
s.push(1);
s.push(2);
s.add(0, 99);     // allowed: LIFO rule broken
s.sort(null);     // also allowed
s.clear();        // ...every List method works

// The JDK made this exact mistake:
// java.util.Stack extends Vector.
//-
if (!s.isEmpty()) throw new AssertionError();
}}
