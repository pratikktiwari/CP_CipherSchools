public class BuyAndSellStock {
    static int buyAndSellStock(int stockPrice[]) {
        int minVal = stockPrice[0], profit = 0;

        for (int i = 1; i < stockPrice.length; i++) {
            if (minVal <= stockPrice[i]) {
                int tempProfit = stockPrice[i] - minVal;
                profit = Math.max(profit, tempProfit);
            } else {
                minVal = stockPrice[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int stockPrice[] = { 100, 200, 300, 150, 180 };
        int profit = buyAndSellStock(stockPrice);
        System.out.println(profit);
    }
}
