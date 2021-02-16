public class LastNonZeroDigit {
    static int dp[] = { 1, 1, 2, 6, 4, 2, 2, 4, 2, 8 };

    static int getLastNonZeroDigit(int n) {
        if (n < 10) {
            return dp[n];
        }
        if (((n / 10) % 10) % 2 == 0) {
            return (6 * getLastNonZeroDigit(n / 5) * dp[n % 10]) % 10;
        } else {
            return (4 * getLastNonZeroDigit(n / 5) * dp[n % 10]) % 10;
        }
    }

    public static void main(String[] args) {
        int res = getLastNonZeroDigit(10);
        System.out.println("Last non-zero digit of 10 : " + res);
    }
}
