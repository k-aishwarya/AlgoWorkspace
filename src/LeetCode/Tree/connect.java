package LeetCode.Tree;

import LeetCode.Tree.common.Node;

import java.util.ArrayList;
import java.util.List;

public class connect {

    public Node connect(Node root) {
        if(root==null) return null;
        List<Node> q = new ArrayList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node n = q.remove(0);
            if(n!=null){
                if(n.left!=null)
                    q.add(n.left);
                if(n.right!=null)
                    q.add(n.right);
                n.next = q.get(0);
            }
            else{
                if(!q.isEmpty())
                    q.add(null);
            }
        }
        return root;
    }
}
