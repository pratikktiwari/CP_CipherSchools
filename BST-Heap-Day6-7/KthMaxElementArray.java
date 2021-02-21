import java.util.*;

public class KthMaxElementArray {
    static int getKthMax(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            int item = pq.remove();
            if (i == k - 1) {
                return item;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 1, 7, 2, 73, 64 };
        int res = getKthMax(arr, 4);
    }
}
