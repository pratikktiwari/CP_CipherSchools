import java.util.*;

public class MergeKSortedArrays {
    static int[] mergeKSortedArrays(int[][] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                pq.add(arr[i][j]);
            }
        }
        int res[] = new int[pq.size()];
        for (int i = 0; i < pq.size(); i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
