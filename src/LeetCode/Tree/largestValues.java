package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class largestValues {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        Integer max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            TreeNode n = q.removeFirst();
            if(n!=null){
                if(max<n.val) max=n.val;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            else{
                if(!q.isEmpty()) q.add(null);
                res.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}
