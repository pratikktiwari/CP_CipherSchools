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

    public void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }

    public void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }
}

public class TreeTraversals {
    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 0; i < 7; i++) {
            t.insert(i);
        }
    }
}
