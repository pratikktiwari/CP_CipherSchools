class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class LinkedList {

    Node head;

    LinkedList add(int val) {
        Node n1 = new Node(val);
        n1.next = null;

        if (this.head == null) {
            this.head = n1;
        } else {
            Node ptr = this.head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = n1;
        }
        return this;
    }

    void printList() {
        Node ptr = this.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }
}

public class DetectAndRemoveLoop {
    static boolean detectLoop(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next;
            if (slowPtr == fastPtr) {
                return true;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return false;
    }

    static boolean removeLoop(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                break;
            }
            slowPtr = slowPtr.next;
            // fastPtr = fastPtr.next;
        }
        // System.out.println("a");
        if (slowPtr != fastPtr)
            return false;

        slowPtr = head.next;
        while (slowPtr != fastPtr) {
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        fastPtr.next = null;
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);

        head.next = one;
        one.next = two;
        two.next = three;
        three.next = one;

        System.out.println("Loop: " + detectLoop(head)); // true
        removeLoop(head); // loop is removed
        System.out.println("Loop: " + detectLoop(head)); // false

    }
}
