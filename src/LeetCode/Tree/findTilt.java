package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class findTilt {

    int tilt=0;

    public int findTiltHelper(TreeNode root) {
        if(root==null) return 0;

        int leftSum = findTiltHelper(root.left);
        int rightSum = findTiltHelper(root.right);

        int sum = leftSum+rightSum+root.val;

        tilt +=Math.abs(leftSum-rightSum);

        return sum;

    }

    public int findTilt(TreeNode root){
        findTiltHelper(root);
        return tilt;
    }

    public static void main(String[] args) {
        findTilt f = new findTilt();
        Integer[] arr = {1,2,3};
        TreeNode root = TreeNode.createSampleTree(arr);
        System.out.println(f.findTilt(root));
    }
}
