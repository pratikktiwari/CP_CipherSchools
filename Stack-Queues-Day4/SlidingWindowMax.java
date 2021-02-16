import java.util.PriorityQueue;

public class SlidingWindowMax {
    static void findMaxOfWindow(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return x < y ? 1 : -1;
            }
        });
        for (int i = 0; i < arr.length - k + 1; i++) {
            pq.clear();
            for (int j = i; j < i + k; j++) {
                pq.add(arr[j]);
            }
            System.out.println("Window [" + i + "] : " + pq.peek());
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 2, 7, 10, 34, 23 };
        findMaxOfWindow(arr, 3);
    }
}
