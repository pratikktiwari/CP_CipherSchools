import java.util.*;

public class NextGreatestElement {
    static int getNextGreatestEleemnt(int arr[], int n) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n)
                break;
            index++;
        }
        index++;
        Stack<Integer> s = new Stack<>();

        while (index < arr.length) {
            if (s.isEmpty()) {
                s.push(arr[index]);
                continue;
            }
            if (arr[index] < n) {
                while (!s.isEmpty() && arr[index] <= s.peek()) {
                    s.pop();
                }
                s.push(arr[index]);
            }
            index++;
        }
        while (!s.isEmpty()) {
            if (s.peek() <= n) {
                s.pop();
            } else {
                break;
            }
        }
        if (s.isEmpty()) {
            System.out.println("No element");
        } else {
            System.out.println("NGE: " + s.peek());
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 2, 7, 10, 34, 23 };
        getNextGreatestEleemnt(arr, 5);
    }
}
