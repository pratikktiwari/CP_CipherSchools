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

public class ReverseInKGroups {
    // yet to be done
    static Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node();
        Node prev = dummy;
        while (head != null) {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        dummy = null;

        return prev;
    }

    static Node reverseInGroups(Node head, int k) {
        Node dummy = new Node(), node = dummy, prev = head;
        int count = k;
        while (head != null) {
            Node temp = head;
            while (count > 0 && head != null) {
                prev = head;
                head = head.next;
                count--;
            }
            if (count == 0) {
                prev.next = null;
                node.next = reverse(temp);
                while (node != null && node.next != null) {
                    node = node.next;
                }
            } else {
                node.next = temp;
            }
            count = k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        for (int i = 1; i < 6; i++) {
            l.add(i);
        }
        Node newNode = reverseInGroups(l.head, 3);
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.next;
        }
    }
}
