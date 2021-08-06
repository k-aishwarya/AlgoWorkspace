package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zigzagLevelOrder {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;

        List<TreeNode> q = new ArrayList<>();
        int evenLevel = 0;

        q.add(root);
        q.add(null);

        List<Integer> levelValues = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode n = q.remove(0);
            if(n!=null){
                levelValues.add(n.val);
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
            }
            else{
                if(!q.isEmpty())
                    q.add(null);
                evenLevel=1-evenLevel;
                if(evenLevel==0){
                    Collections.reverse(levelValues);
                }
                list.add(levelValues);
                levelValues = new ArrayList<>();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer arr[] = {1,2,3,4,5,6,7};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(zigzagLevelOrder(root));
    }
}
