import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {
    static int findElement(int arr[][], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        for (int i = 1; i < k; i++) {
            pq.remove();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int grid[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        int res = findElement(grid, 4);
        System.out.println("4th smallest element : " + res);
    }
}
