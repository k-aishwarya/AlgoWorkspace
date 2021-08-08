package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class buildTree {

    public static TreeNode buildTree(int[] preorder, int[] inorder, int inorderLow, int inorderHigh, int parentPreorderIndex) {
        if(inorderHigh<inorderLow) return null;

        TreeNode root = new TreeNode(preorder[parentPreorderIndex]);
        if(inorderLow==inorderHigh) {
            return root;
        }

        int rootInorderIndex = search(inorder, inorderLow, inorderHigh, root.val);
        int leftRootPreorderIndex = parentPreorderIndex+1;
        int rightRootPreorderIndex = parentPreorderIndex + (rootInorderIndex-inorderLow) + 1;

        root.left = buildTree(preorder, inorder, inorderLow, rootInorderIndex-1, leftRootPreorderIndex);
        root.right = buildTree(preorder, inorder, rootInorderIndex+1, inorderHigh, rightRootPreorderIndex);

        return root;
    }

    static int search (int[] inorder, int low, int high, int key){
        for(int i=low; i<=high; i++) {
            if (inorder[i] == key) return i;
        }
        return -1;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, inorder.length-1, 0);
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode.levelOrder(buildTree(preorder,inorder));
        System.out.println();
    }
}
