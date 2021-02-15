import java.util.*;

public class MergeSortedArray {
    static ArrayList<Integer> mergeSortedArray(int[] first, int[] second) {
        int i = 0, j = 0;
        ArrayList<Integer> result = new ArrayList<>(first.length + second.length);
        while (i < first.length && j < second.length) {
            if (first[i] <= second[j]) {
                result.add(first[i]);
                i++;
            } else {
                result.add(second[j]);
                j++;
            }
        }
        while (i < first.length) {
            result.add(first[i]);
            i++;
        }
        while (j < second.length) {
            result.add(second[j]);
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 6, 12, 65, 100 };
        int arr2[] = { 2, 5, 17, 89 };

        ArrayList<Integer> merged = mergeSortedArray(arr1, arr2);
        for (int x : merged) {
            System.out.print(x + " ");
        }
    }
}