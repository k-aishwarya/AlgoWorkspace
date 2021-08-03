package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class invertTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode n = q.remove(0);
            if(n!=null){
                TreeNode temp = n.left;
                n.left = n.right;
                n.right = temp;
                q.add(n.left);
                q.add(n.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer arr[] = {4,2,7,1,3,6,9};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        TreeNode.levelOrder(invertTree(root));
    }
}
