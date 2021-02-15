public class MissingNumber {
    static int findMissing(int[] arr) {
        int missing = 0;
        for (int i = 0; i < arr.length; i++) {
            missing = missing ^ (i + 1) ^ arr[i];
        }
        missing = missing ^ arr.length + 1;
        return missing;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 5, 6, 7 };
        int missing = findMissing(arr);
        System.out.println("Missing number: " + missing);
    }
}
