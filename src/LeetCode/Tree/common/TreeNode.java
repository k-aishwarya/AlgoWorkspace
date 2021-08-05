package LeetCode.Tree.common;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val,  TreeNode left,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode insert( TreeNode root, Integer[] arr){
        int count=0;
        if(root==null) {
            root = new TreeNode(arr[count++]);
        }
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(count<arr.length) {
            TreeNode n = q.remove(0);
            if (n != null) {
                if(n.left==null){
                    if(arr[count]!=null)
                        n.left = new TreeNode(arr[count++]);
                    else count++;
                }
                q.add(n.left);
                if(n.right==null && count<arr.length){
                    if(arr[count]!=null)
                        n.right = new TreeNode(arr[count++]);
                    else count++;
                }
                q.add(n.right);
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
                 q.add(left);
                 q.add(right);
            }
            boolean elements_left = false;
            for(TreeNode i:q){
                if(i!=null){
                    elements_left=true;
                }
            }
            if(!elements_left) return;
        }
    }

    public static  TreeNode createSampleTree(Integer[] arr){
        if(arr.length<1) return null;
        TreeNode root = null;
        root = insert(root, arr);
        return root;
    }
}
