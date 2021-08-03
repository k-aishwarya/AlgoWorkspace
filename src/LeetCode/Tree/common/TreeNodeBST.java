package LeetCode.Tree.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBST {

    public int val;
    public TreeNodeBST left;
    public TreeNodeBST right;

    public TreeNodeBST() {
    }

    public TreeNodeBST(int val) {
        this.val = val;
    }

    public TreeNodeBST(int val, TreeNodeBST left, TreeNodeBST right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNodeBST insert(TreeNodeBST root, int data) {
        if (root == null) {
            root = new TreeNodeBST(data);
            return root;
        }

        if (data < root.val) root.left = insert(root.left, data);
        else if (data > root.val) root.right = insert(root.right, data);
        else System.out.println("duplicate Data");
        return root;
    }

    public static void levelOrder(TreeNodeBST root) {
        if (root == null) return;
        List<TreeNodeBST> q = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNodeBST n = q.remove(0);
            if (n != null) {
                System.out.print(n.val + " ");
            } else {
                System.out.print("null" + " ");
            }
            if (n != null) {
                TreeNodeBST left = n.left;
                TreeNodeBST right = n.right;
                if (left != null || right != null) {
                    q.add(left);
                    q.add(right);
                }
            }
        }
    }

    public static TreeNodeBST createSampleTree(int[] arr) {
        if (arr.length < 1) return null;
        TreeNodeBST root = new TreeNodeBST(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            root.insert(root, arr[i]);
        }
        return root;
    }
}