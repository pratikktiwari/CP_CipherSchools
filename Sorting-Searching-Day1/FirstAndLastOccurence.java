public class FirstAndLastOccurence {
    static void checkFirstLastOccurence(int arr[], int num) {
        int first = -1, last = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                first = first == -1 ? i : first;
                last = i;
            }
        }
        if (first != -1) {
            System.out.println("First occurence : " + first + "\nLast occurence : " + last);
        } else {
            System.out.println("element not founf");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
        checkFirstLastOccurence(arr, 2);
    }
}
