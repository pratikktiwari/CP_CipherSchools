class Queue {
    int capacity;
    int[] arr = null;
    int front, rear;

    Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        this.front = 0;
        this.rear = 0;
    }

    void enqueue(int num) {
        if (rear == capacity) {
            System.out.println("Queue if full");
        } else {
            arr[rear++] = num;
        }
    }

    void dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty");
        } else {
            front++;
        }
    }

    void clear() {
        front = rear = 0;
    }

    void getQueue() {
        if (front == rear)
            return;
        System.out.print("\n[ ");
        for (int i = front; i < rear; i++) {
            if (arr[i] != 0)
                System.out.print(arr[i] + " ,");
        }
        System.out.print(" ]\n");
    }
}

public class QueueArrayImplementation {
    public static void main(String... args) {
        Queue q1 = new Queue(4);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.enqueue(40);

        q1.getQueue();

        q1.dequeue();

        q1.getQueue();
    }
}
