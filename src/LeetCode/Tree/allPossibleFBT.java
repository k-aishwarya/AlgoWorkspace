package LeetCode.Tree;

import InterviewSet.Tree.Tree;
import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class allPossibleFBT {

    List<List<TreeNode>> mem = new ArrayList<>(20);

    {
        for(int i=0; i<=20; i++){
            mem.add(null);
        }
    }

    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> list = new ArrayList<>();
        if(n%2==0) {
            return new ArrayList<>();
        }

        if(n==1){
            list.add(new TreeNode(0));
            mem.set(1,list);
            return list;
        }

        if(n<mem.size() && mem.get(n)!=null) return mem.get(n);

        for(int i=1; i<n-1; i+=2){
            for(TreeNode leftTree: allPossibleFBT(i)){
                for(TreeNode rightTree: allPossibleFBT(n-1-i)){
                    TreeNode root = new TreeNode(0);
                    root.left=leftTree;
                    root.right=rightTree;
                    list.add(root);
                }
            }
        }
        mem.set(n,list);
        return mem.get(n);
    }

    public static void main(String[] args) {
        allPossibleFBT a = new allPossibleFBT();
        List<TreeNode> list = a.allPossibleFBT(2);
        for(TreeNode t: list){
            TreeNode.levelOrder(t);
            System.out.println();
        }
    }
}
