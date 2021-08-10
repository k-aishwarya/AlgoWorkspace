package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;
import javafx.util.Pair;

public class maxPathSum {

    public static int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] arr = maxPathSumHelper(root);
        return Math.max(arr[0],arr[1]);
    }

    public static int[] maxPathSumHelper(TreeNode root){
        int[] arr = new int[2];
        if(root==null) return null;
        if(root.left==null && root.right==null){
            arr[0]=arr[1]=root.val;
            return arr;
        }
        int[] left = maxPathSumHelper(root.left);
        int[] right =  maxPathSumHelper(root.right);
        if(left!=null&&right!=null){
            arr[0] = Math.max(Math.max(left[0],right[0])+root.val, root.val);
            arr[1] = Math.max(root.val,Math.max(Math.max(left[1],right[1]), left[0]+right[0]+root.val));
        }
        else if(right!=null){
            arr[0] = Math.max(right[0]+root.val, root.val);
            arr[1] = Math.max(root.val,Math.max(Math.max(right[0],right[1]),right[0]+root.val));
        }
        else if(left!=null){
            arr[0] = Math.max(left[0]+root.val, root.val);
            arr[1] = Math.max(root.val,Math.max(Math.max(left[0],left[1]),left[0]+root.val));
        }
        return arr;
    }


    //From Leetcode Solutions

    // "max" attribute stores total max for all the traversals being made till the left and right children
    // postorder returns max including root
    // final ans will be max of the "max" attribute ans postorder func value
    private static int max = Integer.MIN_VALUE;
    public static int maxPathSum_1(TreeNode root) {
        postOrder(root);
        return max;
    }

    private static int postOrder(TreeNode root){
        if(root == null) return 0;
        if(root.left == null && root.right == null){
            max = Math.max(root.val, max);
            return Math.max(0, root.val);
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        max = Math.max(max, Math.max(left+right+root.val, Math.max(root.val, root.val+Math.max(right, left))));

        return Math.max(Math.max(left, right)+root.val, root.val);
    }

    public static void main(String[] args) {
        Integer arr[] = {-1,null,9,-6,3,null,null,null,-2};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(maxPathSum_1(root));
    }


}
