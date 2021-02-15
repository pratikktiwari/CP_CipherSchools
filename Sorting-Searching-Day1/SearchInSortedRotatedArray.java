import java.util.Arrays;

public class SearchInSortedRotatedArray {
    static int findPivot(int arr[], int start, int end) {
        // boundary condition
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;

        if (start == mid)
            return start;
        // base condition
        if (mid < end && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (start < mid && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        }

        if (arr[start] <= arr[mid]) {
            // 1st segment is sorted
            return findPivot(arr, mid + 1, end);
        } else {
            // second segment is sorted
            return findPivot(arr, start, mid - 1);
        }
    }

    static int searchInSortedRotatedArray(int arr[], int x) {
        int i = 0, j = arr.length - 1;
        int pivotElement = findPivot(arr, i, j);

        int res1 = Arrays.binarySearch(arr, i, pivotElement, x);
        int res2 = Arrays.binarySearch(arr, pivotElement + 1, j, x);

        if (res1 < 0) {
            return res2;
        } else {
            return res1;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, 6, 3, 7, 8 };
        int res = searchInSortedRotatedArray(arr, 2);
        System.out.println("Result index : " + res);
    }
}
