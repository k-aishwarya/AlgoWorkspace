package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class recoverTree {
    public static void recoverTree(TreeNode root) {
        if(root==null) return;

        List<TreeNode> inOrder = new ArrayList<>();
        inOrder(root, inOrder);

        TreeNode swap1 = null;
        TreeNode swap2 = null;

        TreeNode prev = inOrder.get(0);
        for(int i=1; i<inOrder.size(); i++){
            if(inOrder.get(i).val<prev.val){
                if(swap1==null){
                    swap1=prev;
                    swap2=inOrder.get(i);
                }
                else{
                    swap2=inOrder.get(i);
                    break;
                }
            }
            prev=inOrder.get(i);
        }

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;
    }

    public static void inOrder(TreeNode root, List<TreeNode> inOrder){
        if(root!=null){
            inOrder(root.left, inOrder);
            inOrder.add(root);
            inOrder(root.right, inOrder);
        }
    }

    public static void main(String[] args) {
        Integer arr[] = {3,1,4,null,null,2};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        recoverTree(root);
        TreeNode.levelOrder(root);
        System.out.println();
    }
}
