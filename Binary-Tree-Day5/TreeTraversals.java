import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.lang.Math;

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

    void PreOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.println(root.data + " ");
                s.push(root);
                root = root.left;
            }
            if (s.isEmpty())
                return;
            root = s.pop();
            root = root.right;
        }
    }

    void InOrderIterative(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<>();
        while (true) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            if (s.isEmpty())
                return;
            root = s.pop();
            System.out.println(root.data + " ");
            root = root.right;
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

    public void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }
}

public class TreeTraversals {
    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 0; i < 7; i++) {
            t.insert(i);
        }
        t.PreOrderIterative(t.root);
    }
}
