import java.util.Stack;

public class ValidParanthesis {
    public static boolean isValid(String s) {
        if (s.length() == 0)
            return true;
        if (s.length() == 1)
            return false;
        boolean track = false;
        Stack<Character> left = new Stack<Character>();
        Stack<Character> right = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[')
                left.push(match(c));
            else {
                right.push(c);
                if (left.isEmpty())
                    return false;
                if (left.pop() != c) {
                    return false;
                } else
                    right.pop();
            }
        }
        if (right.isEmpty() && left.isEmpty())
            return true;
        else
            return false;

    }

    static char match(char c) {
        switch (c) {
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '(';
        }
    }

    public static void main(String[] args) {
        String s1 = "()]{";
        System.out.println(isValid(s1));
    }
}
// https://leetcode.com/problems/valid-parentheses/submissions/
