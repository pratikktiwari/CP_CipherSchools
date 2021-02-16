import java.util.Stack;

public class ReverseStackRecursion {
    static void insertAtBottom(Stack<Integer> s, int elem) {
        if (s.isEmpty())
            s.push(elem);
        else {
            int top = s.pop();
            insertAtBottom(s, elem);
            s.push(top);
        }
    }

    static void reverse(Stack<Integer> s) {
        if (s.isEmpty())
            return;
        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
