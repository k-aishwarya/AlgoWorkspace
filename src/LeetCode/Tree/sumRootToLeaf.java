package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class sumRootToLeaf {

    public static int sumRootToLeaf(TreeNode root, int parent, int sum) {
        if(root==null) return sum;
        int left = sumRootToLeaf(root.left, parent * 2 + root.val, sum);
        int right = sumRootToLeaf(root.right, parent * 2 + root.val, sum);
        if(root.left==null && root.right==null){
            return sum + parent * 2 + root.val;
        }
        return left+right;
    }

    public static int sumRootToLeaf( TreeNode root) {
        return sumRootToLeaf(root, 0, 0);
    }

    public static void main(String[] args) {
        Integer arr[] = {1,0,1,0,1,0,1};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(sumRootToLeaf(root));

    }
}
