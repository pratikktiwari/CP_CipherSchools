public class SortZeroOneTwo {
    static void swap(int arr[], int first, int second) {
        int temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
    }

    static void sort(int arr[]) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 0:
                    zeroCount++;
                    continue;
                case 1:
                    oneCount++;
                    continue;
                case 2:
                    twoCount++;
                    continue;
                default:
                    break;
            }
        }
        int i = 0;
        while (zeroCount > 0) {
            arr[i] = 0;
            i++;
            zeroCount--;
        }
        while (oneCount > 0) {
            arr[i] = 1;
            i++;
            oneCount--;
        }
        while (twoCount > 0) {
            arr[i] = 2;
            i++;
            twoCount--;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
