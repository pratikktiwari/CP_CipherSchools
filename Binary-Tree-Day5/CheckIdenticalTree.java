import java.util.Queue;
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

    void level_order_traverse() {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        System.out.println();
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            System.out.print(current.data + "  ");
            if (current.left != null)
                q.offer(current.left);
            if (current.right != null)
                q.offer(current.right);
        }
        System.out.println();
    }
}

public class CheckIdenticalTree {
    static boolean checkIterativeIdentical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode curr1 = q1.poll();
            TreeNode curr2 = q2.poll();

            if (q1.size() != q2.size())
                return false;

            if (curr1.left != null)
                q1.offer(curr1.left);
            if (curr1.right != null)
                q1.offer(curr1.right);
            if (curr2.left != null)
                q2.offer(curr2.left);
            if (curr2.right != null)
                q2.offer(curr2.right);
        }
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        return false;
    }

    static boolean checkIdenticalRecursive(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;
        else if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
            return false;
        else
            return checkIdenticalRecursive(root1.left, root2.left) && checkIdenticalRecursive(root1.right, root2.right);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode();
        root1.data = 1;
        TreeNode n2 = new TreeNode();
        n2.data = 2;
        TreeNode n3 = new TreeNode();
        n3.data = 3;
        TreeNode n4 = new TreeNode();
        n4.data = 4;

        root1.left = n2;
        root1.right = n3;
        n3.right = n4;

        Tree t2 = new Tree();
        t2.insert(4);
        t2.insert(5);
        t2.insert(6);
        t2.insert(7);

        Tree t1 = new Tree();
        t1.insert(4);
        t1.insert(5);
        t1.insert(6);
        t1.insert(7);

        // System.out.println("Check t1 & t2: " + checkIdenticalRecursive(root1,
        // t2.root));
        System.out.println("Check t1 & t2: " + checkIdenticalRecursive(t1.root, t2.root));
    }
}
