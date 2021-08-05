package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

public class FindElements {

    TreeNode root = null;

    public FindElements(TreeNode root) {
        if(root==null) return;
        this.recover(root,0);
        this.root = root;
    }

    public void recover(TreeNode root, int value){
        if(root==null) return;
        root.val = value;
        recover(root.left, 2*value+1);
        recover(root.right, 2*value+2);
    }

    public boolean find(int target) {
        if(root==null) return false;
        return find(root,target);
    }

    public boolean find(TreeNode root, int target){
        if(root==null) return false;
        if(root.val==target) return true;
        return find(root.left,target) || find(root.right,target);
    }

}
