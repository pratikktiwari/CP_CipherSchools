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

    private void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }

    public void print(TreeNode root) {
        print("", root, false);
    }
}

public class SumAllNodes {

    static int getSum(TreeNode root, int currentSum) {
        if (root == null)
            return 0;

        int leftSum = getSum(root.left, currentSum);
        int rightSum = getSum(root.right, currentSum);

        return root.data + leftSum + rightSum;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 1; i < 5; i++) {
            t.insert(i);
        }
        t.print(t.root);
        int sum = getSum(t.root, 0);
        System.out.println(sum);
    }
}