package BST-Heap-Day6;

public

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

class BST {
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
        TreeNode pre = root;
        TreeNode current = root;
        while (current != null) {
            if (data < current.data) {
                pre = current;
                root = root.left;
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

    void inorder(TreeNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
}

public class BSTCrud {
    public static void main(String[] args) {
        BST t = new BST();
        for (int i = 0; i < 10; i++) {
            t.insert(i);
        }
        t.inorder(t.root);
    }
}
