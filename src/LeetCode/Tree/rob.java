package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class rob {

    public static int rob(TreeNode root) {
        int[] arr = robHelper(root);
        return Math.max(arr[0],arr[1]);
    }

    public static int[] robHelper(TreeNode root) {
        int[] arr = new int[2];
        if(root==null) return arr;
        int[] left = robHelper(root.left);
        int[] right = robHelper(root.right);

        arr[0] = left[1]+right[1]+root.val;
        arr[1] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        return arr;
    }

}
