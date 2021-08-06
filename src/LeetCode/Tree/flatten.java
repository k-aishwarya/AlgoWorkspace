package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.Stack;

public class flatten {

    public static void flatten(TreeNode root, Stack<TreeNode> s) {
        if(root==null) return;

        if(root.right!=null){
            s.push(root.right);
        }

        if(root.left!=null){
            flatten(root.left, s);
            root.right = root.left;
            root.left=null;
        }
        else{
            if(!s.isEmpty()) {
                TreeNode n = s.pop();
                flatten(n, s);
                root.right = n;
            }
        }
    }

    public static void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        flatten(root,s);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,5,3,4,6,7};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        flatten(root);
        TreeNode.levelOrder(root);
        System.out.println();
    }


}
