//Linear time => m+n, Constant Space
public class SearchInSortedMatrix {
    static void search(int arr[][], int x) {
        int i = 0, j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("Found at [" + i + "][" + j + "]");
                return;
            } else if (arr[i][j] > x) {
                // elements are to the left, so move left
                j--;
            } else {
                // if elements are not to the left, move down
                i++;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int grid[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        search(grid, 25);
    }
}
