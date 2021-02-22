public class KnapSack {
    static int findProfit(int weight[], int profit[], int W) {
        int itemCount = weight.length;
        int dp[][] = new int[weight.length + 1][W + 1];
        for (int i = 1; i <= itemCount; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    dp[i][w] = Math.max(profit[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[itemCount][W];
    }

    public static void main(String[] args) {
        int weight[] = { 1, 2, 5, 6, 7 };
        int profit[] = { 1, 6, 18, 22, 28 };
        int res = findProfit(weight, profit, 11);

        System.out.println(res);
    }
}
