package InterviewSet.Tree;

public class Tree {
    int data;
    Tree left;
    Tree right;

    public Tree(int data){
        this.data = data;
        left=right=null;
    }

    public Tree insert(Tree root, int data){
        if(root==null) {
            root = new Tree(data);
            return root;
        }

        if(data<root.data) root.left = insert(root.left, data);
        else if (data>root.data) root.right = insert(root.right, data);
        else System.out.println("duplicate Data");
        return root;
    }

    public void inOrder(Tree root){
        if(root!=null){
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public static Tree createSampleTree(int[] arr){
        if(arr.length<1) return null;
        Tree root = new Tree(arr[0]);
        for(int i=1; i<arr.length; i++){
            root.insert(root, arr[i]);
        }
//        root.inOrder(root);
        return root;
    }

}
