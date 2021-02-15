//Linear Time, Constant Space
public class SegregateZeroAndOne {
    static void swap(int arr[], int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static void sort(int arr[]) {
        int onePtr = arr.length - 1;
        int zeroPtr = 0;

        while (onePtr > zeroPtr) {
            if (arr[zeroPtr] == 0)
                zeroPtr++;
            if (arr[onePtr] == 1)
                onePtr--;
            if (arr[zeroPtr] == 1 && arr[onePtr] == 0) {
                swap(arr, zeroPtr, onePtr);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
        sort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
