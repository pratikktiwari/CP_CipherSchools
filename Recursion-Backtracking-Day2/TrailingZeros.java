public class TrailingZeros {
    static int countTrailingZeros(int n) {
        int count = 0;
        if (n < 0)
            return -1;
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        return count;
    }

    public static void main(String[] args) {
        int res = countTrailingZeros(10);
        System.out.println("Trailing zeros: " + res);
    }
}
