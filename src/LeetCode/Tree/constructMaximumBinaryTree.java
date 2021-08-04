package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class constructMaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums, int low, int high) {
        if(nums==null || nums.length<1) return null;
        if(low>high) return null;
        int max = low;
        for(int i=low; i<=high; i++) {
            if(nums[max]<nums[i]) max = i;
        }

        TreeNode root = new TreeNode(nums[max]);
        root.left = constructMaximumBinaryTree(nums, low, max-1);
        root.right = constructMaximumBinaryTree(nums, max+1, high);
        return root;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {3,2,1,6,0,5};
        TreeNode root =  constructMaximumBinaryTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
    }
}
