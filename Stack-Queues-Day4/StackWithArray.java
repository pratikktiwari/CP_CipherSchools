class stack {
    int top;
    int MAX = 4;
    int arr[] = new int[MAX];

    stack() {
        top = -1;
    }

    void push(int data) {
        if (top == MAX) {
            incrementSize();
            arr[++top] = data;
            // throw new RuntimeException("Stack overflow");
        } else
            arr[++top] = data;
    }

    void incrementSize() {
        int arr1[] = new int[MAX * 2];
        for (int i = 0; i < MAX; i++) {
            arr1[i] = arr[i];
        }
        this.arr = arr1;
        MAX = MAX * 2;
    }

    int pop() {
        if (top <= -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            return arr[top--];
        }
    }

    int peek() {
        if (top <= -1) {
            return -1;
        }
        return arr[top];
    }
}

public class StackWithArray {
    public static void main(String... args) {
        stack s = new stack();
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.peek());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        System.out.println(s.peek());
    }
}
