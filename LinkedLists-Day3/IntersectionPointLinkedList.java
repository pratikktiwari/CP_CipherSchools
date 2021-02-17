class Node {
    int data;
    Node next;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

public class IntersectionPointLinkedList {
    static int lengthCounter(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    static Node checkIntersectionPoint(Node head1, Node head2) {
        if (head1 == null || head2 == null)
            return null;

        int len1 = lengthCounter(head1);
        int len2 = lengthCounter(head2);

        if (len1 > len2) {
            int diff = len1 - len2;
            while (diff >= 0) {
                head1 = head1.next;
                diff--;
            }
        } else if (len1 < len2) {
            int diff = len2 - len1;
            while (diff >= 0) {
                head2 = head2.next;
                diff--;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        if (head1 != null) {
            return head1;
        }
        return null;

    }

    public static void main(String[] args) {
        Node head1 = new Node(0);
        Node oOne = new Node(1);
        head1.next = oOne;
        Node head2 = new Node(0);
        Node tOne = new Node(2);
        head2.next = tOne;

        Node intersect = new Node(10);
        oOne.next = intersect;
        tOne.next = intersect;
        intersect.next = null;

        Node point = checkIntersectionPoint(head1, head2);
        System.out.println("Intersection Node: " + point.data);
    }
}
