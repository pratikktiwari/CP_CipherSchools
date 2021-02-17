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

public class SortLinkedList {
    static void print(Node head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    static void insert(Node head, Node node) {
        Node ptr = head;
        Node pre = ptr;
        while (ptr != null && ptr.data < node.data) {
            pre = ptr;
            ptr = ptr.next;
        }
        node.next = ptr;
        pre.next = node;
    }

    static Node insertionSort(Node head) {
        Node dummy = new Node(Integer.MIN_VALUE);
        Node dummyRef = dummy;

        Node ptr = head;
        while (ptr != null) {
            Node temp = ptr.next;

            dummy = dummyRef;
            while (dummy.next != null && ptr.data > dummy.next.data) {
                dummy = dummy.next;
            }
            Node temp2 = dummy.next;
            dummy.next = ptr;
            ptr.next = temp2;
            ptr = temp;
        }
        return dummyRef.next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();

        for (int i = 0; i < 5; i++) {
            int num = (int) (10.0 * Math.random());
            l.add(num);
        }
        System.out.println("Initial Unsorted: ");
        l.printList();
        l.head = insertionSort(l.head);
        System.out.println("\nSorted: ");
        l.printList();
    }
}
