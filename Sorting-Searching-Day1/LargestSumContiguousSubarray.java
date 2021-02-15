public class LargestSumContiguousSubarray {
    static int findMaxSumSubarray(int arr[]) {
        int global_max = arr[0];
        int local_max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            local_max = Math.max(local_max + arr[i], arr[i]);
            if (local_max > global_max)
                global_max = local_max;
        }
        return global_max;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 4, -6, 1, 5, -2, 4 };
        int maxSum = findMaxSumSubarray(arr);
        System.out.println("Max sum: " + maxSum);
    }
}
