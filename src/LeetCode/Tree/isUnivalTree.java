package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class isUnivalTree {

    TreeNode curVal = null;

    public boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        if(curVal==null){
            curVal = root;
        }
        if(root.val!=curVal.val) return false;
        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }

    public static void main(String[] args) {
        isUnivalTree u = new isUnivalTree();
        Integer arr[] = {1,1,1,2,1,null,1};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(u.isUnivalTree(root));
    }
}
