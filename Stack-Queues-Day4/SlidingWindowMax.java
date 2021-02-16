import java.util.*;
import java.util.LinkedList;

public class SlidingWindowMax {
    static void findMaxOfWindow(int arr[], int k) {
        Deque<Integer> q = new LinkedList<>();
        int min = arr[0];
        for (int i = 0; i < k; i++) {
            if (q.isEmpty()) {
                q.offer(arr[i]);
            } else {
                if (q.peek() < min) {
                    q.offerFirst(arr[i]);
                }
            }
        }
        for (int i = k + 1; i < n; i++) {

        }

    }
}
