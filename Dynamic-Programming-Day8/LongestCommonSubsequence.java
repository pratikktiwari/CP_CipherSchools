public class LongestCommonSubsequence {
    static int getLCS(String a, String b) {
        int m = a.length(), n = b.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) != b.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                else
                    dp[i][j] = 1 + dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String a = "hello";
        String b = "buffalo";
        int res = getLCS(a, b);
        System.out.println(res);
    }
}
