public class HeapSort {
    static void sort(int arr[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            percolateDown(arr, n, i);
    }

    static int leftChild(int i, int n) {
        return (2 * i + 1) >= n ? -1 : (2 * i + 1);
    }

    static int rightChild(int i, int n) {
        return (2 * i + 2) >= n ? -1 : (2 * i + 2);
    }

    static void swap(int arr[], int A, int B) {
        int temp = arr[A];
        arr[A] = arr[B];
        arr[B] = temp;
    }

    static void percolateDown(int arr[], int n, int i) {
        while (i < n) {
            int left = leftChild(i, n);
            int right = rightChild(i, n);

            int max = i;

            if (left != -1 && arr[i] < arr[left])
                max = left;
            if (right != -1 && arr[max] < arr[right])
                max = right;
            if (max != i) {
                swap(arr, max, i);
                i = max;
            } else
                break;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 16, 5, 7 };
        sort(arr, arr.length);
        for (int x : arr) {
            System.out.print(x + ", ");
        }
    }
}
