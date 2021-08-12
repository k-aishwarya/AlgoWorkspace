package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;


// From discussion
public class deleteNode {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        if(root.val == key){
            if(root.right != null){
                if(root.left != null){
                    TreeNode left = root.right;
                    while(left.left != null){
                        left = left.left;
                    }
                    left.left = root.left;
                }
                return root.right;
            }
            return root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        Integer arr[] = {5,3,6,2,4,null,7};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        TreeNode.levelOrder(deleteNode(root,3));
    }

}
