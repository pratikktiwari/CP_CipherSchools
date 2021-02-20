import java.util.Queue;
import java.util.LinkedList;
import java.lang.Math;

class TreeNode {
    char data;
    TreeNode left, right;

    TreeNode() {
        data = '0';
        left = null;
        right = null;
    }
}

class Tree {
    TreeNode root;

    Tree() {
        root = null;
    }

    void insert(char data) {
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

    void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
}

public class TreeFromInorderPreorder {
    static int findPositionFromInPre(String pre, String in) {
        int pos = 0;
        for (int i = 0; i < pre.length(); i++) {
            for (int j = 0; j < in.length(); j++) {
                if (pre.charAt(i) == in.charAt(j)) {
                    pos = j;
                    return pos;
                }
            }
        }
        return pos;
    }

    static void construct_tree(TreeNode root, String pre, String in) {
        if (in.length() == 0) {
            return;
        } else if (in.length() == 1) {
            root.data = in.charAt(0);
            return;
        } else {
            int pos = findPositionFromInPre(pre, in);
            root.data = in.charAt(pos);

            if (in.substring(0, pos).length() > 0) {
                TreeNode left = new TreeNode();
                root.left = left;
                construct_tree(root.left, pre, in.substring(0, pos));
            }
            if (in.substring(pos + 1, in.length()).length() > 0) {
                TreeNode right = new TreeNode();
                root.right = right;
                construct_tree(root.right, pre, in.substring(pos + 1, in.length()));
            }
        }
    }

    public static void main(String[] args) {
        String pre = "ABDECF";
        String in = "DBEAFC";
        // String pre = "12489AB5367";
        // String in = "84A9B251637";

        TreeNode root = new TreeNode();
        Tree t = new Tree();
        t.root = root;

        construct_tree(t.root, pre, in);

        System.out.println("\nPre Order:\n");
        t.preOrder(t.root);
    }
}
