package LeetCode.Tree;

public class rangeSumBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) {
            return 0;
        }
        if(root.val>=low && root.val<=high){
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
        return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {
        int arr[] = {10,5,15,3,7,18};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(rangeSumBST(root, 7, 15));

    }
}
