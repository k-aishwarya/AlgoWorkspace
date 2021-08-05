package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.Stack;


// Link- https://algorithms.tutorialhorizon.com/construct-binary-search-tree-from-a-given-preorder-traversal-using-stack-without-recursion/

public class bstFromPreorder {

    public static TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null || preorder.length<1) return null;

        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        s.add(root);

        for(int i=1; i<preorder.length; i++){
            TreeNode x = null;
            while (!s.isEmpty() && preorder[i] > s.peek().val) {
                x = s.pop();
            }
            if (x != null) {
                x.right = new TreeNode(preorder[i]);
                s.push(x.right);
            } else {
                s.peek().left = new TreeNode(preorder[i]);
                s.push(s.peek().left);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {19,4,8,11};
        TreeNode root = bstFromPreorder(preorder);
        TreeNode.levelOrder(root);
        System.out.println();
    }

}
