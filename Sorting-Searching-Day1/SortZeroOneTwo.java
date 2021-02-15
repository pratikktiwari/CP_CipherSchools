public class SortZeroOneTwo {
    static void swap(int arr[], int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static void sort(int arr[]) {
        int onePtr = 0;
        int zeroPtr = 0;
        int twoPtr = arr.length - 1;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
    }
}
