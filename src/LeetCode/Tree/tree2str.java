package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class tree2str {
    public static String tree2str(TreeNode root) {
        if(root==null) return null;
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        String resp = String.valueOf(root.val);
        if(left!=null||right!=null){
            if(left!=null) resp+="("+left+")";
            else resp+="()";
            if(right!=null) resp+="("+right+")";
        }
        return resp;
    }

    public static void main(String[] args) {
        Integer arr[] = {1,2,3,null,4};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(tree2str(root));
    }
}
