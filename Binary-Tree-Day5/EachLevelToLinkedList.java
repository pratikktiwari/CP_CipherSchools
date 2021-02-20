import java.util.Queue;
import java.util.List;
import java.util.LinkedList;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode() {
        data = 0;
        left = null;
        right = null;
    }
}

class Tree {
    TreeNode root;

    Tree() {
        root = null;
    }

    void insert(int data) {
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();

            if (current.left != null)
                q.offer(current.left);
            else {
                current.left = newNode;
                return;
            }
            if (current.right != null)
                q.offer(current.right);
            else {
                current.right = newNode;
                return;
            }
        }
    }

    private void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }

    public void print() {
        print("", root, false);
    }
}

public class EachLevelToLinkedList {
    // Doubly LinkedList where right represents next pointer, left represents prev
    // pointer
    static List<TreeNode> convertLevelToList(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode pre = new TreeNode();
        TreeNode first = pre;
        q.offer(null);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                if (q.peek() != null) {
                    q.offer(null);
                }
                pre.right = null;

                res.add(first.right);

                pre = new TreeNode();
                first = pre;
            } else {
                pre.right = current;
                pre = current;
                // ============================
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }
        }
        return res;
    }

    static void printFormedList(List<TreeNode> list) {
        for (TreeNode node : list) {
            while (node != null) {
                System.out.print(node.data + "  ");
                node = node.right;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 1; i < 10; i++) {
            t.insert(i);
        }
        t.print();
        List<TreeNode> res = convertLevelToList(t.root);
        printFormedList(res);
    }
}
