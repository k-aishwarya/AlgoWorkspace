package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class sumNumbers {

    public static void sumNumbers(TreeNode root, List<Integer> pathNumbers, int path) {
        if(root==null) return;

        if(root.left==null && root.right==null){
            pathNumbers.add((path*10)+root.val);
        }

        sumNumbers(root.left, pathNumbers,(path*10)+root.val);
        sumNumbers(root.right, pathNumbers,(path*10)+root.val);

    }

    public static int sumNumbers(TreeNode root) {

        List<Integer> nums = new ArrayList<>();
        sumNumbers(root,nums,0);
        return nums.stream().mapToInt(Integer::intValue).sum();

    }

    public static void main(String[] args) {
        Integer arr[] = {1,2,3};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(sumNumbers(root));
    }


}
