import java.util.*;

public class NumberDecoding {
    static String map = "_ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static void decodeStringHelper(List<String> result, String digits, int index, String strSoFar) {
        if (index >= digits.length()) {
            result.add(strSoFar);
            return;
        }
        int idx1 = Integer.valueOf(digits.charAt(index) - '0');
        if (idx1 == 0)
            return;
        decodeStringHelper(result, digits, index + 1, strSoFar + map.charAt(idx1));
        if (index + 1 >= digits.length())
            return;

        int idx2 = Integer.valueOf(digits.charAt(index + 1) - '0');
        if (10 * idx1 + idx2 <= 26)
            decodeStringHelper(result, digits, index + 2, strSoFar + map.charAt(10 * idx1 + idx2));
    }

    static List<String> decodeString(String digits) {
        if (digits.length() == 0)
            return new ArrayList<String>();
        List<String> result = new ArrayList<>();
        decodeStringHelper(result, digits, 0, "");
        for (String item : result) {
            System.out.println(item);
        }
        return result;
    }

    static int decodeWays(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String x = "20";
        decodeString(x);
    }
}
