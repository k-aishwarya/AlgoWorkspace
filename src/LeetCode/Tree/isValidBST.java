package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class isValidBST {

    public static boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null && root.left.val>=root.val){
            return false;
        }
        if(root.right!=null && root.right.val<=root.val){
            return false;
        }

        TreeNode temp = root.left;
        if(temp!=null){
            while(temp.right!=null){
                temp = temp.right;
            }
            if(temp.val>=root.val) {
                return false;
            }
        }

        temp = root.right;
        if(temp!=null){
            while(temp.left!=null){
                temp = temp.left;
            }
            if(temp.val<=root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public static void main(String[] args) {
        Integer arr[] = {120,70,140,50,100,130,160,20,55,75,110,119,135,150,200};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(isValidBST(root));
    }
}
