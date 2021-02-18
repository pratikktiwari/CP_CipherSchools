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

public class ArrangementOddEvenNodes {
    static void print(Node head) {
        Node ptr = head;
        System.out.println();
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static Node oddEvenArrange(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node oddDummy = new Node(), oddRef = oddDummy;
        Node evenDummy = new Node(), evenRef = evenDummy;

        while (head != null) {
            if (head.data % 2 == 0) {
                evenDummy.next = head;
                evenDummy = evenDummy.next;
            } else {
                oddDummy.next = head;
                oddDummy = oddDummy.next;
            }
            head = head.next;
        }
        oddDummy.next = null;
        evenDummy.next = oddRef.next;
        return evenRef;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        for (int i = 1; i < 5; i++) {
            l1.add(i + 4);
            l1.add(i * 2);
        }
        Node newNode = oddEvenArrange(l1.head);
        print(newNode);
    }
}
