import java.util.Stack;

public class NextSmallerElement {
    static int getNextSmallerElement(int arr[], int item) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item)
                break;
            index++;
        }
        index++;
        index = index == arr.length ? index - 1 : index;

        Stack<Integer> s = new Stack<>();

        while (index >= 0) {
            if (s.isEmpty() && arr[index] < item) {
                s.push(arr[index]);
                index--;
                continue;
            }

            if (arr[index] < item && arr[index] > s.peek()) {
                s.push(arr[index]);
            }
            index--;
        }
        while (!s.isEmpty()) {
            if (s.peek() >= item) {
                s.pop();
            } else {
                break;
            }
        }
        if (s.isEmpty()) {
            return -1;
        } else {
            return s.peek();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 2, 5, 3, 7, 10, 34, 23 };
        for (int x : arr) {
            System.out.println(x + " => " + getNextSmallerElement(arr, x));
        }
    }
}
