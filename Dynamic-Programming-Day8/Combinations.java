public class Combinations {
    static int findCombination(int N, int R) {
        if (N < R)
            return -1;
        else if (N == R)
            return 1;
        else if (R == 1)
            return N;

        int dp[][] = new int[N + 1][R + 1];

        for (int n = 0; n <= N; n++) {
            for (int r = 0; r <= R; r++) {
                if (r > n) {
                    continue;
                }
                if (n == 0 || r == 0) {
                    dp[n][r] = 1;
                    continue;
                }

                dp[n][r] = dp[n - 1][r] + dp[n - 1][r - 1];
            }
        }
        // for (int row[] : dp) {
        // for (int val : row) {
        // System.out.print(val + " ");
        // }
        // System.out.println();
        // }
        return dp[N][R];
    }

    public static void main(String[] args) {
        int res = findCombination(10, 5);
        System.out.println(res);
    }
}
