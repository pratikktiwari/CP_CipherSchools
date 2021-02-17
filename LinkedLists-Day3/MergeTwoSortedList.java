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

public class MergeTwoSortedList {
    static Node mergeTwoList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node dummy = new Node();
        Node dummyRef = dummy;
        Node ptr1 = head1, ptr2 = head2;

        while (ptr1 != null && ptr2 != null) {
            if (ptr1.data < ptr2.data) {
                dummy.next = ptr1;
                ptr1 = ptr1.next;
                dummy = dummy.next;
            } else {
                dummy.next = ptr2;
                ptr2 = ptr2.next;
                dummy = dummy.next;
            }
        }
        while (ptr1 != null) {
            dummy.next = ptr1;
            ptr1 = ptr1.next;
            dummy = dummy.next;
        }
        while (ptr2 != null) {
            dummy.next = ptr2;
            ptr2 = ptr2.next;
            dummy = dummy.next;
        }
        dummy.next = null;
        return dummyRef.next;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        for (int i = 1; i < 15; i *= 3) {
            l1.add(i);
            l2.add(i + 3);
            l3.add(i * 2);
        }

        Node newHead = mergeKList(l1.head, l2.head);
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }
}
