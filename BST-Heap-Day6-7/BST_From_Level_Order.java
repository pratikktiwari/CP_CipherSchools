import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode() {
        data = 0;
        left = null;
        right = null;
    }

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class BST {
    TreeNode root;

    BST() {
        root = null;
    }

    void insert(int data) {
        TreeNode newNode = new TreeNode();
        newNode.data = data;
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode pre = root;
        TreeNode current = root;
        while (current != null) {
            if (data < current.data) {
                pre = current;
                current = current.left;
            } else {
                pre = current;
                current = current.right;
            }
        }
        if (pre.data > data)
            pre.left = newNode;
        else
            pre.right = newNode;
    }

    public void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }
}

public class BST_From_Level_Order {
    public static void main(String[] args) {
        int[] level_order = { 25, 23, 27, 15, 24, 26, 29 };
        BST t = new BST();
        for (int i = 0; i < level_order.length; i++) {
            t.insert(level_order[i]);
        }
    }
}