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

    static Node reverse(Node head) {
        if (head == null)
            return null;
        head.next = reverse(head.next);
        return head;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.add(2);
        l.add(3);
        l.add(5);

        l.printList();
        l.head = reverse(l.head);
        System.out.println("\nReversed:\n");
        l.printList();
    }
}
