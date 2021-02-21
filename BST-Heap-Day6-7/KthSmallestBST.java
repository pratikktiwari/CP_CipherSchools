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

public class KthSmallestBST {
    static int count = 1;

    static TreeNode kthSmallest(TreeNode root, int k) {
        if (root == null)
            return null;
        if (kthSmallest(root.left, k) != null) {
            return root;
        }
        if (count == k) {
            System.out.println(root.data);
            return root;
        }

        count++;
        return kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        int arr[] = { 8, 3, 10, 1, 6, 14, 5, 4, 7, 13 };
        BST t = new BST();
        for (int i : arr) {
            t.insert(i);
        }

        kthSmallest(t.root, 3);
    }
}
