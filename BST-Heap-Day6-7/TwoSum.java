import java.util.*;

public class TwoSum {
    static int[] findTwoSum(int arr[], int sum) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(sum - arr[i])) {
                return new int[] { arr[i], sum - arr[i] };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int arr[] = { 1, 5, 2, 5, 2, 63, 6, 68 };
        int res[] = findTwoSum(arr, 7);
    }
}
