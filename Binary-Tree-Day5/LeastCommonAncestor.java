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
}

public class LeastCommonAncestor {
    static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }
        TreeNode left = LCA(root.left, a, b);
        TreeNode right = LCA(root.right, a, b);

        if (left != null && right != null) {
            return root;
        } else {
            return a == null ? b : a;
        }
    }
    public static void main(String[] args) {
        
    }
}
