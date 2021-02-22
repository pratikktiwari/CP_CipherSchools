public class MinimumJumps {
    static int getMinJumps(int[] arr) {
        int N = arr.length;
        if (N == 0) {
            return Integer.MAX_VALUE;
        }
        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j]) {
                    if (dp[j] != Integer.MAX_VALUE) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                        break;
                    }
                }
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 2, 8, 4, 8, 4 };
        int res = getMinJumps(arr);
        System.out.println(res);
    }
}
