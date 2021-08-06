package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        List<List<Integer>> left = pathSum(root.left, targetSum-root.val);
        List<List<Integer>> right = pathSum(root.right, targetSum-root.val);

        if(left.isEmpty() && right.isEmpty()){
            if(targetSum==root.val && root.left==null && root.right==null){
                paths = new ArrayList<>();
                List<Integer> path = new ArrayList<>();
                path.add(0,root.val);
                paths.add(path);
                return paths;
            }
        }
        if(!left.isEmpty()){
            for(List<Integer> path: left){
                path.add(0,root.val);
                paths.add(path);
            }
        }
        if(!right.isEmpty()) {
            for(List<Integer> path: right){
                path.add(0,root.val);
                paths.add(path);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(pathSum(root, 22));
    }
}
