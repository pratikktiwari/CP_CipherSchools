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

public class RootToLeafPaths {
    
    static void print_paths(TreeNode root) {
        if (root == null)
            return;
        ArrayList<String> al = new ArrayList<String>();
        dfs(root, al, "");
        for (int i = 0; i < al.size(); i++) {
            String s = al.get(i);
            System.out.println(s);
        }
    }

    static void dfs(TreeNode root, ArrayList<String> al, String path) {
        path += root.data;
        if (root.left == null && root.right == null) {
            al.add(path);
            return;
        }
        if (root.left != null)
            dfs(root.left, al, path + "->");
        if (root.right != null)
            dfs(root.right, al, path + "->");
    }

    static boolean root_to_node_path(TreeNode root, TreeNode node, ArrayList<Integer> al) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        al.add(root.data);
        if (root_to_node_path(root.left, node, al) || root_to_node_path(root.right, node, al))
            return true;
        al.remove(al.size() - 1);
        return false;
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

        // print_paths(t.root);
        ArrayList<Integer> al = new ArrayList<Integer>();
     

    //  root_to_node_path(t.root, t.root.left.left.left, al);
        print_paths(t.root);
        System.out.println(al);
    }
}

    
    

    