package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class rightSideView {


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightView = new ArrayList<>();

        if(root==null) return rightView;

        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode n = q.remove(0);
            if(n!=null){
                if(q.get(0)==null){
                    rightView.add(n.val);
                }
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            else{
                if(!q.isEmpty())
                    q.add(null);
            }
        }
        return  rightView;
    }
}
