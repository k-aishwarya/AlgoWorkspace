package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null) return null;
        if(root==p) return root;
        if(root==q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);

        if(left!=null&&right!=null){
            return root;
        }
        if(left!=null) return left;
        else return right;
    }
}
