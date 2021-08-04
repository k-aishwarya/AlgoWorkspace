package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class averageOfLevels {

    public static List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return null;
        List<TreeNode> q = new ArrayList<>();
        List<Double> ans = new ArrayList<>();
        q.add(root);
        q.add(null);
        double curSum = 0;
        double count=0;
        while(!q.isEmpty()){
            TreeNode n = q.remove(0);
            if(n!=null){
                curSum+=n.val;
                count++;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            else{
                double avg=curSum/count;
                double temp = (double) Math.round(avg*100000);
                ans.add(temp/100000.0);
                if(!q.isEmpty()) q.add(null);
                curSum=0;
                count=0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Integer arr[] = {-57762,9,20,null,null,15,7};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(averageOfLevels(root));
    }
}
