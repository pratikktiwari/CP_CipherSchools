import java.util.Stack;

public class ValidParanthesis {
    static void check(String str) {
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                s.push('(');
            if (str.charAt(i) == ')' && !s.isEmpty()) {
                s.pop();
                continue;
            }
            if (s.isEmpty()) {
                System.out.println("Not balanced");
                return;
            }
        }
        if (!s.isEmpty())
            System.out.println("Not balanced");
        else
            System.out.println("Balanced");
    }

    public static void main(String... args) {
        String s1, s2, s3, s4, s5;
        s1 = "(()(()()))";
        s2 = "()((())";
        s3 = "()()))()";
        s4 = "(";
        s5 = "))";
        check(s1);
        check(s2);
        check(s3);
        check(s4);
        check(s5);
    }
}
