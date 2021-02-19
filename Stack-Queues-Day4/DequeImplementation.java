import java.lang.RuntimeException;

class Deque {
    int arr[];
    int front;
    int rear;
    int MAX;

    Deque(int MAX) {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.MAX = MAX;
    }

    boolean isEmpty() {
        return front == -1 ? true : false;
    }

    boolean isFull() {
        return ((front == 0 && rear == MAX - 1) || front == rear + 1);
    }

    int offerFirst(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = MAX - 1;
        } else {
            front = front - 1;
        }
        arr[front] = value;
        return value;
    }

    int offerLast(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (front == -1) {
            front = 0;
            rear = 0;
        } else if (rear == MAX - 1) {
            rear = 0;
        } else {
            rear = rear + 1;
        }
        arr[rear] = value;
        return value;
    }

    int pollFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty");
        }
        int f = front;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            if (front == MAX - 1) {
                front = 0;
            } else {
                front = front + 1;
            }
        }
        return arr[f];
    }

    int pollLast() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is already empty");
        }
        int f = front;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = MAX - 1;
        } else {
            rear = rear - 1;
        }
        return arr[f];
    }
}

public class DequeImplementation {
    public static void main(String[] args) {

    }
}
