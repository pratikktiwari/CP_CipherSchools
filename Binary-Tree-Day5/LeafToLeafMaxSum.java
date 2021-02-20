import java.util.Queue;
import java.util.ArrayList;
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
}

public class LeafToLeafMaxSum {
    static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    static int leafToleafMaxSum(TreeNode root, int sum) {
        if (root == null) {
            sum = 0;
            return 0;
        }
        if (isLeaf(root)) {
            sum = 0;
            return root.data;
        }
        int leftSum = leafToleafMaxSum(root.left, sum);
        int rightSum = leafToleafMaxSum(root.right, sum);
        if (root.left != null && root.right != null) {
            sum = max(sum, leftSum + rightSum + root.data);
            return max(leftSum, rightSum) + root.data;
        } else if (root.left != null) {
            return root.data + rightSum;
        } else {
            return root.data + leftSum;
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 0; i < 10; i++) {
            t.insert(i);
        }

        int res = leafToleafMaxSum(t.root, 0);
        System.out.println(res);
    }
}
