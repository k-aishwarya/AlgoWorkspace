package LeetCode.Tree.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,  TreeNode left,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode insert( TreeNode root, int data){
        if(root==null) {
            root = new  TreeNode(data);
            return root;
        }
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.remove(0);
            if (n != null) {
                if(n.left==null){
                    n.left = new TreeNode(data);
                    break;
                }
                else{
                    q.add(n.left);
                }
                if(n.right==null){
                    n.right = new TreeNode(data);
                    break;
                }
                else{
                    q.add(n.right);
                }
            }
        }
        return root;
    }

    public static void levelOrder( TreeNode root){
        if(root==null) return;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
             TreeNode n = q.remove(0);
            if (n != null) {
                System.out.print(n.val + " ");
            }
            else{
                System.out.print("null" + " ");
            }
            if (n != null) {
                 TreeNode left = n.left;
                 TreeNode right = n.right;
                if(left!=null || right!=null){
                    q.add(left);
                    q.add(right);
                }
            }
        }
    }

    public static  TreeNode createSampleTree(int[] arr){
        if(arr.length<1) return null;
         TreeNode root = new  TreeNode(arr[0]);
        for(int i=1; i<arr.length; i++){
            root.insert(root, arr[i]);
        }
        return root;
    }
}
