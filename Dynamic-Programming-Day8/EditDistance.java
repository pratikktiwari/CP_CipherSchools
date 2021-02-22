public class EditDistance {
    static int editDistanceString(String a, String b) {
        int m = a.length();
        int n = b.length();

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = j;
                else if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "help";

        int res = editDistanceString(a, b);
        System.out.println(res);
    }
}
