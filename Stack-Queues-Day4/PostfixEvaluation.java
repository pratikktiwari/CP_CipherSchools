import java.util.*;

public class PostfixEvaluation {
    public static void evaluate(String str) {
        Stack<Integer> s = new Stack<Integer>();
        int a, b;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '+') {
                a = s.pop();
                b = s.pop();
                s.push(a + b);
            } else if (ch == '-') {
                a = s.pop();
                b = s.pop();
                s.push(b - a);
            } else if (ch == '*') {
                a = s.pop();
                b = s.pop();
                s.push(b * a);
            } else if (ch == '%') {
                a = s.pop();
                b = s.pop();
                s.push(b % a);
            } else if (ch == '/') {
                a = s.pop();
                b = s.pop();
                s.push(b / a);
            } else {
                int x = (int) ch - (int) '0';
                s.push(x);
            }
        }
        System.out.println(s.pop());
    }

    public static void main(String... args) {
        evaluate("123*+5-");
    }
}
