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

public class PalindromeLinkedList {
    static Node reverse(Node head) {
        Node ptr = head;

        Node pre = null;
        while (ptr != null) {
            Node temp = ptr.next;
            ptr.next = pre;
            pre = ptr;
            ptr = temp;
        }
        return pre;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + "-> ");
            head = head.next;
        }
    }

    static boolean checkPalindrome(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        if (fastPtr != null) {
            slowPtr = slowPtr.next;
        }
        fastPtr = head;
        slowPtr = reverse(slowPtr);

        while (slowPtr != null) {
            if (slowPtr.data != fastPtr.data) {
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        // l1.add(1);
        // l1.add(2);
        // l1.add(3);
        // l1.add(2);
        // l1.add(1);
        // l1.add(6);
        for (int i = 1; i < 3; i++) {
            l1.add(i);
        }
        for (int i = 2; i >= 1; i--) {
            l1.add(i);
        }
        boolean res = checkPalindrome(l1.head);
        System.out.println("Palindrome: " + (res ? "Yes" : "No"));
    }
}
