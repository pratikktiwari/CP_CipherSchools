import java.util.*;

class Node {
    int data;
    Node next;
    Node random;

    Node(int val) {
        this.data = val;
        this.next = null;
        this.random = null;
    }

    Node(int val, Node random) {
        this.data = val;
        this.next = null;
        this.random = random;
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

public class CloneWithRandomPointers {
    static void print(Node head) {
        Node ptr = head;
        System.out.println();
        while (ptr != null) {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }

    static Node cloneList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node ptr = head;

        while (ptr != null) {
            map.put(ptr, new Node(ptr.val));
            ptr = ptr.next;
        }
        ptr = head;

        while (ptr != null) {
            Node clone = map.get(ptr);
            clone.next = map.get(ptr.next);
            clone.random = map.get(ptr.random);

            ptr = ptr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {

    }
}
