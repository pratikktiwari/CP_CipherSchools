import java.util.*;

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

public class TreeTraversalIterative {
    static void pre_order(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode current = s.pop();
            System.out.print(current.data + " ");
            if (current.right != null)
                s.push(current.right);
            if (current.left != null)
                s.push(current.left);
        }
    }

    static void in_order(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        boolean done = false;
        while (!done) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                if (s.isEmpty())
                    done = true;
                else {
                    current = s.pop();
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    public static void post_order(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode current = root;
        while (!s.isEmpty() || current != null) {
            if (current != null) {
                s.push(current);
                current = current.left;
            } else {
                TreeNode temp = s.peek().right;
                if (temp == null) {
                    temp = s.pop();
                    System.out.print(temp.data + " ");
                    while (!s.isEmpty() && temp == s.peek().right) {
                        temp = s.pop();
                        System.out.print(temp.data + " ");
                    }
                } else
                    current = temp;
            }
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 1; i <= 7; i++) {
            t.insert(i);
        }

        System.out.println("\nPre");
        pre_order(t.root);
        System.out.println("\nIn");
        in_order(t.root);
        System.out.println("\nPost");
        post_order(t.root);
    }
}
