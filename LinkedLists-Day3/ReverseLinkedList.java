class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
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

public class ReverseLinkedList {
    static Node reverseRecursive(Node head) {
        if (head == null) {
            return head;
        }
        if (head.next == null)
            return head;
        Node dummy = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return dummy;
    }

    static Node reverseIterative(Node head) {
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

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(2);
        l.add(3);
        l.add(5);

        l.printList();
        l.head = reverseIterative(l.head);
        System.out.println("\nReversed:\n");
        l.printList();
    }
}
