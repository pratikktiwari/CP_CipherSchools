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
            System.out.println("Queue is full");
            return -1;
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
            System.out.println(" Queue is full ");
            return -1;
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

    void pollFirst() {
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }

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
    }

    void pollLast() {
        if (isEmpty()) {
            System.out.println(" Queue Underflow");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = MAX - 1;
        } else {
            rear = rear - 1;
        }
    }
}

public class DequeImplementation {
    public static void main(String[] args) {

    }
}
