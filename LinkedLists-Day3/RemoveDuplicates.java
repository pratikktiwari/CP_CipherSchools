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
            System.out.print(ptr.data + " -->");
            ptr = ptr.next;
        }
        System.out.println();
    }

    void removeDup() {
        // sort using merge sort => remove duplicates
        Node ptr = head;
        Node pre = ptr;
        while (ptr != null) {
            if (s.contains(ptr.data)) {
                pre.next = ptr.next;
            } else {
                s.add(ptr.data);
            }
            pre = ptr;
            ptr = ptr.next;
        }
        traverse();
    }
}

public class RemoveDuplicates {
    public static void main(String args[]) {
        LinkedList l = new LinkedList();
        l.add(2);
        l.add(2);
        l.add(4);
        l.add(6);
        l.add(8);
        l.add(6);

        l.traverse();
        l.removeDup();
    }
}
