package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class kthSmallest {
    static Integer cur=0;
    {
        cur=0;
    }

    public static int kthSmallest(TreeNode root, int k) {
        if(root!=null){
            int left = kthSmallest(root.left, k);
            cur++;
            if(k==cur) return root.val;
            int right = kthSmallest(root.right, k);
            return Math.max(left, right);
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer arr[] = {5,3,6,2,4,null,null,1};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        int result = kthSmallest(root, 3);
        System.out.println(result);

    }
}
