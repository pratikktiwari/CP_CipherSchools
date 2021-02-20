import java.util.Queue;
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

public class DiameterBinaryTree {
    static int d = 0;

    public static int find_height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = find_height(root.left);
        int rh = find_height(root.right);

        return Math.max(lh, rh) + 1;
    }

    public static void diameter(TreeNode root) {
        if (root == null)
            return;
        int lh = find_height(root.left);
        int rh = find_height(root.right);

        d = Math.max(d, lh + rh + 1);
        diameter(root.left);
        diameter(root.right);
    }

    // short code for diameter
    public int diameterOfBinaryTree(TreeNode root) {
        diameter_h(root);
        return d;
    }

    public int diameter_h(TreeNode node) {
        if (node == null)
            return 0;

        int left = diameter_h(node.left);
        int right = diameter_h(node.right);

        d = Math.max(d, left + right);

        return Math.max(left, right) + 1;
    }

    // ends here
    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);

        diameter(t.root);
        System.out.println("Height: " + find_height(t.root));
        System.out.println("Diameter is: " + DiameterBinaryTree.d);
    }
}
