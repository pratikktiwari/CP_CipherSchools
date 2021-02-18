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
        // split list and merge them one by one
        if (head == null || head.next == null) {
            return head;
        }
        Node head1, head2;
        Node slowPtr = head, fastPtr = head;
        Node pre = slowPtr;
        while (fastPtr != null && fastPtr.next != null) {
            pre = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        pre.next = null;
        head1 = head;
        head2 = slowPtr;
        Node dummy = new Node();
        Node dummyRef = dummy;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;

                dummy.next = head2;
                head2 = head2.next;
                dummy = dummy.next;
            } else if (head2 != null) {
                dummy.next = head2;
                head2 = head2.next;
                dummy = dummy.next;
            } else if (head1 != null) {
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;
            }
        }
        dummy.next = null;
        return dummyRef.next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 1; i <= 10; i++) {
            l.add(i);
        }
        l.head = reorderList(l.head);
        l.printList();
    }
}
