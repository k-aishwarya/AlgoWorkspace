package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class diameterOfBinaryTree {


    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        diameterOfBinaryTreeHelper(root,diameter);
        return diameter.get();
    }

    public int diameterOfBinaryTreeHelper(TreeNode root,AtomicInteger diameter) {
        if(root==null) return 0;
        int left = diameterOfBinaryTreeHelper(root.left,diameter);
        int right = diameterOfBinaryTreeHelper(root.right,diameter);

        diameter.set(Math.max(left+right, diameter.get()));

        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        diameterOfBinaryTree d = new diameterOfBinaryTree();
        Integer[] arr = {1,2,3,4,5};
        TreeNode root = TreeNode.createSampleTree(arr);
        System.out.println(d.diameterOfBinaryTree(root));
    }
}
