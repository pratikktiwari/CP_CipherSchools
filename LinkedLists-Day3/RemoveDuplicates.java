import java.util.*;

class Node {
    int data;
    Node next;

    Node() {
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    void add(int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            head = newNode;
        } else {
            Node ptr = head;
            while (ptr.next != null) {
                ptr = ptr.next;
            }
            ptr.next = newNode;
        }
    }

    void traverse() {
        Node ptr = head;
        System.out.println();
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}

public class RemoveDuplicates {
    static Node removeDup(Node head) {
        Node ptr = head;
        while (ptr != null) {
            Node iptr = ptr.next;
            while (iptr != null && iptr.data == ptr.data) {
                iptr = iptr.next;
            }
            ptr.next = iptr;
            ptr = ptr.next;
        }
        return head;
    }

    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        l.add(2);
        l.add(6);
        l.add(6);
        l.add(6);
        l.add(8);

        l.traverse();
        l.head = removeDup(l.head);
        l.traverse();
    }
}
