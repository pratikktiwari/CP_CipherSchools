import java.util.*;

public class GenerateParenthesis {
    static void generate(int n) {
        List<String> output_arr = new ArrayList<>();
        backtrack(output_arr, "", 0, 0, n);

        for (String item : output_arr) {
            System.out.println(item);
        }
    }

    static void backtrack(List<String> output_arr, String current, int open, int close, int n) {
        if (current.length() == n * 2) {
            output_arr.add(current);
        }
        if (open < n) {
            backtrack(output_arr, current + "(", open + 1, close, n);
        }
        if (close < open) {
            backtrack(output_arr, current + ")", open, close + 1, n);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        generate(n);
    }
}
