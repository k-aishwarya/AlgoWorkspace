package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class countNodes {

    public static int countNodes(TreeNode root) {
        if(root==null) return 0;

        int height = 1;
        TreeNode temp = root;
        while(temp.left!=null){
            temp=temp.left;
            height++;
        }

        int missingNodes = preorder(root, 1, height);

        return (int) Math.pow(2, height) -1 - missingNodes;
    }

    public static int preorder(TreeNode root, Integer curLevel, Integer height){
        if(root!=null){
            if(curLevel==height-1) {
                if(root.left!=null){
                    if(root.right==null) return 1;
                    else return 0;
                }
                if(root.right==null) return 2;
            }
            int right = preorder(root.right,curLevel+1,height);
            int left = preorder(root.left, curLevel+1, height);
            return left+right;
        }
        return 0;
    }

    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5,6,7,8,9,10};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(countNodes(root));
    }

}
