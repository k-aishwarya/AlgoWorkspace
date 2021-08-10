package LeetCode.Tree;

import java.util.Stack;


// Link - https://www.programcreek.com/2015/01/leetcode-verify-preorder-serialization-of-a-binary-tree-java/
public class isValidSerialization {
    public static boolean isValidSerialization(String preorder) {
        if(preorder==null || preorder.isEmpty()) return true;
        String[] arr = preorder.split(",");
        Stack<String> s = new Stack<>();
        for(String x: arr){
            if(s.isEmpty() || !x.equals("#")){
                s.push(x);
            }
            else{
                while(!s.isEmpty() && s.peek().equals("#")){
                    s.pop();
                    if(!s.isEmpty()) s.pop();
                    else return false;
                }
                s.push("#");
            }
        }
        return s.size()==1 && s.peek().equals("#");
    }

    public static void main(String[] args) {
        String s = "9,3,4,#,#,1,#,#,2,#,6,#,#";
//        String s = "9,#,#,1";
//        String s = "1,#";
        System.out.println(isValidSerialization(s));
    }
}
