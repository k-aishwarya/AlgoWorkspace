package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode n = q.remove(0);
            if (n != null) {
                sb.append(n.val+",");
                TreeNode left = n.left;
                TreeNode right = n.right;
                q.add(left);
                q.add(right);
            }
            else{
                boolean elements_left = false;
                for(TreeNode i:q){
                    if(i!=null){
                        elements_left=true;
                    }
                }
                if(!elements_left) return sb.toString();
                sb.append("null,");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String[] arr = data.split(",");
        int count=0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[count++]));
        List<TreeNode> q = new ArrayList<>();
        q.add(root);
        while(count<arr.length) {
            TreeNode n = q.remove(0);
            if (n != null) {
                if(n.left==null){
                    if(arr[count].equals("null")) {
                        count++;
                    }
                    else{
                        n.left = new TreeNode(Integer.parseInt(arr[count++]));
                    }
                }
                q.add(n.left);
                if(n.right==null && count<arr.length){
                    if(arr[count].equals("null")) {
                        count++;
                    }
                    else{
                        n.right = new TreeNode(Integer.parseInt(arr[count++]));
                    }
                }
                q.add(n.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        Integer arr[] = {-57762,9,20,null,null,15,7};
        TreeNode root =  TreeNode.createSampleTree(arr);

        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);

        TreeNode.levelOrder(ans);
    }
}
