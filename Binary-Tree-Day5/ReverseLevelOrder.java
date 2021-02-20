import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

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

    public void print() {
        print("", root, false);
    }
}

public class ReverseLevelOrder {
    static void reverseLevelOrder(TreeNode root) {
        if (root == null)
            return;
        Stack<Integer> s = new Stack<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                if (q.peek() != null) {
                    q.offer(null);
                }
                s.push(null);
                continue;
            }
            s.push(current.data);

            if (current.right != null)
                q.offer(current.right);
            if (current.left != null)
                q.offer(current.left);
        }
        for (Integer x : s) {
            if (x == null)
                System.out.println();
            else
                System.out.print(x + " ");
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 0; i < 10; i++) {
            t.insert(i);
        }
        reverseLevelOrder(t.root);
    }
}
