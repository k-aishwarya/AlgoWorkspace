package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;
import java.util.LinkedList;

public class findBottomLeftValue {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null) return -1;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        TreeNode prev = null;
        TreeNode BottomLeftValueNode = root;
        while(!q.isEmpty()){
            TreeNode n = q.removeFirst();
            if(n!=null){
                if(prev==null) BottomLeftValueNode=n;
                if(n.left!=null) q.add(n.left);
                if(n.right!=null) q.add(n.right);
            }
            else{
                if(!q.isEmpty()) q.add(null);
            }
            prev=n;
        }
        return BottomLeftValueNode.val;
    }
}
