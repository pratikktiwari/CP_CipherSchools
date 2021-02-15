import java.util.PriorityQueue;

public class KthSmallestNumber {
    static int kThSmallestNumber(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 1; i < k; i++) {
            pq.remove();
        }
        return pq.peek();
    }

    static void kSmallestNumbers(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        System.out.println("K smallest elements: ");
        for (int i = 0; i < k; i++) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 4, 6, 9, 2, 7, 3 };
        int res = kThSmallestNumber(arr, 1);
        System.out.println("Kth Smallest Element: " + res);
        kSmallestNumbers(arr, 3);
    }
}
