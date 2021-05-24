package InterviewSet.Tree;

public class LCA {

    public static Tree LCA(Tree root, int a, int b){
        if(root==null) return null;
        if(a>root.data && b>root.data) return LCA(root.right, a,b);
        if(a<root.data && b<root.data) return LCA(root.left, a,b);
        return root;
    }

    public static void main(String[] args) {
        int[] arr = {20,8,22,4,12,10,14};
        Tree root = Tree.createSampleTree(arr);
        Tree lca = LCA.LCA(root, 4,14);
        if(lca!=null){
            System.out.println(lca.data);
        }
        else {
            System.out.println("No LCA found!");
        }
    }

}
