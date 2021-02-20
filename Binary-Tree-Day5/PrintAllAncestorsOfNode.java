import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

    public void print(String prefix, TreeNode n, boolean isLeft) {
        if (n != null) {
            print(prefix + "     ", n.right, false);
            System.out.println(prefix + ("|=> ") + n.data);
            print(prefix + "     ", n.left, true);
        }
    }
}

public class PrintAllAncestorsOfNode {
    static boolean printAllAncestors(Node root, Node node, List<Integer> path) {
        if (root == null) {
            return false;
        }
        if (root == node) {
            path.add(root.data);
            return true;
        }
        path.add(root.data);
        if ((root.left != null) && printAllAncestors(root.left, node, path)) {
            return true;
        }
        if ((root.right != null) && printAllAncestors(root.right, node, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        for (int i = 0; i < 6; i++) {
            t.insert(i);
        }
        // node = some node
        List<Integer> list = new ArrayList<>();
        printAllAncestors(t.root, node, list);
    }
}
