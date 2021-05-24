package InterviewSet.Tree;

public class IdentifyBst{

    public static boolean isBST(Tree root){
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isBSTUtil(Tree root, int min, int max){
        if(root==null) return true;

        if(root.data<min || root.data>max)
            return false;

        return isBSTUtil(root.left, min, root.data-1) && isBSTUtil(root.right, root.data+1, max);

    }

    public static void main(String args[])
    {
        // Let us construct the BST shown in the above figure
        Tree root = new Tree(20);
        root.left = new Tree(8);
        root.right = new Tree(22);
        root.left.left = new Tree(4);
        root.left.right = new Tree(12);
        root.left.right.left = new Tree(10);
        root.left.right.right = new Tree(14);

        System.out.println(isBST(root));

        root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.left.right.left = new Tree(6);
        root.left.right.right = new Tree(7);

        System.out.println(isBST(root));


    }
}
