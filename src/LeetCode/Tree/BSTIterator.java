package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    private int pointer=-1;
    private List<TreeNode> inOrder;
    private int count=0;

    public BSTIterator(TreeNode root) {
        if(root!=null) {
            inOrder= new ArrayList<>();
            inOrder(root);
            pointer=0;
        }
    }

    public int next() {
        if(pointer>=0 && pointer<count){
            return this.inOrder.get(pointer++).val;
        }
        else return 0;
    }

    private void inOrder(TreeNode root){
        if(root!=null){
            inOrder(root.left);
            this.inOrder.add(root);
            count++;
            inOrder(root.right);
        }
    }

    public boolean hasNext() {
        return pointer<count;
    }
}
