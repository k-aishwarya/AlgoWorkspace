package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class buildTreePostOrder {
    public static TreeNode  buildTree(int[] inorder, int[] postorder, int inorderLow, int inorderHigh, int parentPostOrderIndex) {
        if(inorderHigh<inorderLow) return null;

        TreeNode root = new TreeNode(postorder[parentPostOrderIndex]);
        if(inorderLow==inorderHigh) return root;

        int inorderRootIndex = inorderLow;
        while(inorderRootIndex<=inorderHigh && inorder[inorderRootIndex]!=root.val) inorderRootIndex++;

        int leftRootPostOrderIndex = parentPostOrderIndex-(inorderHigh-inorderRootIndex)-1;
        int rightRootPostOrderIndex = parentPostOrderIndex-1;

        root.left = buildTree(inorder, postorder, inorderLow, inorderRootIndex-1, leftRootPostOrderIndex);
        root.right = buildTree(inorder, postorder, inorderRootIndex+1, inorderHigh, rightRootPostOrderIndex);

        return root;
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0 , inorder.length-1, postorder.length-1);
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};

        TreeNode.levelOrder(buildTree(inorder,postorder));
        System.out.println();
    }
}
