import java.util.Stack;

public class LargestAreaUnderHisogram {
    static int getLargestRect(int arr[]) {
        int area = 0, max_area = 0, top = 0, i = 0, n = arr.length;
        Stack<Integer> s = new Stack<>();
        while (i < n) {
            if (s.isEmpty() || arr[s.peek()] <= arr[i]) {
                top = s.pop();
                if (s.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i - s.peek() - 1);
                }
                max_area = Math.max(max_area, area);
            }
        }
        while (s.isEmpty()) {
            top = arr[s.pop()];
            if (s.isEmpty()) {
                area = arr[top] * i;
            } else {
                area = arr[top] * i;
            }
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }

    public static void main(String[] args) {
        int arr[] = { 5, 2, 6, 1, 6, 3 };
        int res = getLargestRect(arr);
        System.out.println("Largest area: " + res);
    }
}
