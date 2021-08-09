package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class levelOrderBottom {

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;

        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        q.add(null);

        List<Integer> temp = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode n = q.remove(0);
            if(n!=null){
                temp.add(n.val);
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            else{
                if(!q.isEmpty()) q.add(null);
                res.addFirst(temp);
                temp = new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {};
        TreeNode root = TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        System.out.println(levelOrderBottom(root));
    }
}
