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

public class SortedArrayToBST {
    static TreeNode convertBST(int arr[], int start, int end) {
        // top bottom approach
        if (start > end)
            return null;

        TreeNode newNode = new TreeNode();

        int mid = (start + end) / 2;
        newNode.data = arr[mid];
        newNode.left = convertBST(arr, start, mid - 1);
        newNode.right = convertBST(arr, mid + 1, end);

        return newNode;
    }

    static int tracker = 0;

    static TreeNode convertBSTBottomUp(int arr[], int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode left = convertBSTBottomUp(arr, start, mid - 1);
        TreeNode root = new TreeNode(arr[tracker++]);
        root.left = left;
        TreeNode right = convertBSTBottomUp(arr, mid + 1, end);
        root.right = right;

        return root;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        BST t = new BST();
        // preorder => top down approach
        t.root = convertBST(arr, 0, arr.length - 1);
        t.print("", t.root, false);
        // inorder => bottom up approach
        t.root = convertBSTBottomUp(arr, 0, arr.length - 1);
        t.print("", t.root, false);
    }
}
