package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class findTarget {
    public static boolean findTarget(TreeNode root, int k) {
        List<Integer> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        int i=0, j=inOrder.size()-1;
        while(j>i){
            int sum = inOrder.get(i) + inOrder.get(j);
            if(sum>k) j--;
            else if(sum<k) i++;
            else return true;
        }
        return false;
    }

    public static void inOrder(TreeNode root, List<Integer> inOrder){
        if(root!=null){
            inOrder(root.left, inOrder);
            inOrder.add(root.val);
            inOrder(root.right, inOrder);
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {2,1,3};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(findTarget(root,1));
    }

}
