public class BinarySearch {
    static void binarySearch(int arr[], int item) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == item) {
                System.out.println("Found at index : " + mid);
                return;
            } else if (arr[mid] > item) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 6, 12, 15, 20 };
        binarySearch(arr, 20);
    }
}