package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum3 {

    static int count=0;

    public static int pathSum(TreeNode root, int targetSum) {
        pathSum(root, targetSum, new ArrayList<>());
        return count;
    }

    public static void pathSum(TreeNode root, int targetSum, List<Integer> path) {
        if(root==null) return;
        path.add(root.val);
        int sum=0;
        for(int i=path.size()-1; i>=0; i--){
            sum+=path.get(i);
            if(sum==targetSum) {
                count++;
            }
        }

        pathSum(root.left, targetSum, path);
        pathSum(root.right, targetSum, path);
        path.remove(path.size()-1);

    }

    public static void main(String[] args) {
        Integer[] arr = {0,1,1};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(pathSum(root, 1));
    }
}
