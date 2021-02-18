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

public class UnionOfTwoList {
    static void print(Node head) {
        Node ptr = head;
        System.out.println();
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static Node findUnion(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node dummy = new Node();
        Node dummyRef = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;

            } else if (head1.data > head2.data) {
                dummy.next = head2;
                dummy = dummy.next;
                head2 = head2.next;
            } else {
                dummy.next = head1;
                dummy = dummy.next;
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        dummy.next = null;
        return dummyRef.next;

    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();
        for (int i = 1; i < 5; i++) {
            l1.add(i + 4);
            l2.add(i * 2);
        }
        Node newNode = findUnion(l1.head, l2.head);
        print(newNode);
    }
}
