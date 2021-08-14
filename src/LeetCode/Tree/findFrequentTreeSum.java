package LeetCode.Tree;

import LeetCode.Tree.common.TreeNode;

import java.util.*;

public class findFrequentTreeSum {

    static Map<Integer,Integer> m = new HashMap<>();
    static int maxFrequency=0;
    {
        m = new HashMap<>();
        maxFrequency=0;
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        findFrequentTreeSumHelper(root);
        List<Integer> arr = new ArrayList<>();
        for(Integer key: m.keySet()){
            if(maxFrequency==m.get(key)){
                arr.add(key);
            }
        }

        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static int findFrequentTreeSumHelper(TreeNode root) {
        if(root==null) return 0;
        int left = findFrequentTreeSumHelper(root.left);
        int right = findFrequentTreeSumHelper(root.right);

        int sum = root.val;

        sum+=left+right;

        m.compute(sum, (k, v) -> (v == null) ? 1 : v+1);
        maxFrequency = Math.max(maxFrequency,m.get(sum));

        return sum;
    }

    public static void main(String[] args) {
        Integer arr[] = {5,2,-5};
        TreeNode root =  TreeNode.createSampleTree(arr);
        TreeNode.levelOrder(root);
        System.out.println();
        int[] res = findFrequentTreeSum(root);
        for(int i=0; i< res.length; i++){
            System.out.println(res[i]);
        }
    }

}
