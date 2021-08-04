package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class sortedArrayToBST {

    public static TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if(nums==null || nums.length<1) return null;
        if(low>high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, low, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, high);
        return root;
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {-10,-3,0,5,9};
        TreeNode root =  sortedArrayToBST(arr);
        TreeNode.levelOrder(root);
        System.out.println();
    }
}
