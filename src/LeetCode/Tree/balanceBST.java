package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class balanceBST {

    public static void inOrder(TreeNode root, List<TreeNode> inOrder){
        if(root!=null){
            inOrder(root.left, inOrder);
            inOrder.add(root);
            inOrder(root.right, inOrder);
        }
    }

    public static TreeNode balanceBST(List<TreeNode> inOrder, int low, int high) {
        if(inOrder==null || inOrder.isEmpty()) return null;
        if(low>high) return null;
        int mid = (low+high)/2;
        TreeNode root = new TreeNode(inOrder.get(mid).val);
        root.left = balanceBST(inOrder, low, mid-1);
        root.right = balanceBST(inOrder, mid+1, high);
        return root;
    }


    public static TreeNode balanceBST(TreeNode root) {
        List<TreeNode> inOrder = new ArrayList<>();
        inOrder(root, inOrder);
        TreeNode newRoot = balanceBST(inOrder,0,inOrder.size()-1);
        return newRoot;
    }

    public static void main(String[] args) {
        Integer arr[] = {1,null,2,null,3,null,4,null,null};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        TreeNode newRoot =  balanceBST(root);
        TreeNode.levelOrder(newRoot);
        System.out.println();
    }


}
