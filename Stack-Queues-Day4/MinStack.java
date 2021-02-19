import java.util.Stack;

public class MinStack {
    static int getMin;

    static int getMinimum() {
        return getMin;
    }

    static void push(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            getMin = val;
        } else {
            int top = s.peek();
            if (val >= getMin) {
                s.push(val);
            } else {
                s.push(2 * val - getMin);
                getMin = val;
            }
        }
    }

    static void pop(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        } else {
            int y = s.peek();
            if (y >= getMin) {
                s.pop();
            } else {
                getMin = 2 * getMin - y;
                s.pop();
            }
        }
    }

    public static void main(String[] args) {

    }
}
