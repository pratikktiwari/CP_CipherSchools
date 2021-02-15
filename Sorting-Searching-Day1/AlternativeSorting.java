import java.util.Arrays;

public class AlternativeSorting {
    static void sortAlternate(int[] arr) {
        Arrays.sort(arr);

        int startPtr = 0;
        int endPtr = arr.length - 1;

        while (endPtr >= startPtr) {
            System.out.print(arr[endPtr] + " " + arr[startPtr] + " ");
            startPtr++;
            endPtr--;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 9, 4, 3, 7, 8, 2 };

        sortAlternate(arr);
    }
}
