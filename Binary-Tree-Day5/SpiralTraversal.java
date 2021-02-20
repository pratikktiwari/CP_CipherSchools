import java.util.Queue;
import java.util.List;
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

public class SpiralTraversal {
    static void zizZag(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean rtl = false;

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            if (current == null) {
                if (q.peek() != null)
                    q.offer(null);

                if (rtl) {
                    // print s and empty it
                    while (!s.isEmpty()) {
                        TreeNode node = s.pop();
                        System.out.print(node.data + " - ");
                    }
                }
                System.out.println();
                rtl = rtl ? false : true;
                continue;
            }
            if (rtl) {
                s.push(current);
            } else {
                System.out.print(current.data + " , ");
            }
            if (current.left != null)
                q.offer(current.left);
            if (current.right != null)
                q.offer(current.right);
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.insert(9);

        zizZag(t.root);
    }
}
