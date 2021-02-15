//Linear Time, Constant Space

public class PeakElementArray {
    static int getPeakElement(int arr[]) {
        if (arr.length == 1)
            return arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i])
                return arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 20, 4, 1, 0 };
        System.out.println(getPeakElement(arr));
    }
}
