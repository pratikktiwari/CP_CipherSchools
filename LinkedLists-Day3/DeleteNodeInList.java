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

    void printList() {
        Node ptr = this.head;
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
    }
}

public class DeleteNodeInList {
    static Node deleteFromList(Node head, int value) {
        Node dummy = new Node();
        dummy.next = head;
        Node pre = dummy;
        Node ptr = head;
        while (head != null) {
            if (ptr.data == value) {
                pre.next = ptr.next;
                break;
            }
            pre = ptr;
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 0; i < 6; i++) {
            l.add(i);
        }
        l.head = deleteFromList(l.head, 3);
        l.printList();
    }
}
