public class CoinExchange {
    static int coinChange(int coins[], int amount) {
        int count = coins.length;
        int dp[][] = new int[amount + 1][count];
        for (int c = 0; c < count; c++) {
            dp[0][c] = 1;
        }
        for (int s = 1; s <= amount; s++) {
            for (int c = 0; c < count; c++) {
                if (s >= coins[c]) {
                    dp[s][c] += dp[s - coins[c]][c];
                }
                if (c >= 1) {
                    dp[s][c] += dp[s][c - 1];
                }
            }
        }
        return dp[amount][count - 1];

    }

    public static void main(String[] args) {
        int coins[] = { 2, 5, 10 };
        int res = coinChange(coins, 50);
        System.out.println(res);
    }
}
