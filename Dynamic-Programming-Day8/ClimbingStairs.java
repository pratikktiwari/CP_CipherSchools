public class ClimbingStairs {
    static int findWays(int N) {
        if (N == 0) {
            return 1;
        }
        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int n = 2; n <= N; n++) {
            dp[n] = dp[n - 1] + dp[n - 2];
        }
        // for (int x : dp) {
        // System.out.print(x + " ");
        // }
        return dp[N];
    }

    public static void main(String[] args) {
        int ways = findWays(3);
        System.out.println("Ways: " + ways);
    }
}
