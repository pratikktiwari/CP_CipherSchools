import java.util.*;

class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }

    Node() {
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

    void addAll(int arr[]) {
        for (int x : arr) {
            this.add(x);
        }
    }

    void printList() {
        Node ptr = this.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }
}

public class ReorderList {
    static Node reorderList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node head1, head2;
        Node slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 1; i <= 5; i++) {
            l.add(i);
        }
    }
}
