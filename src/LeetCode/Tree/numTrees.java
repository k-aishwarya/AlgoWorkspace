package LeetCode.Tree;

// Link - https://stackoverflow.com/questions/24755059/leetcode-unique-binary-search-trees-calculation

public class numTrees {
    public static int numTrees(int n) {
        if(n<1) return 0;
        int[] trees = new int[n+1];
        trees[0]=1;

        for(int i=1; i<=n; i++){
            for(int j=0; j<i; j++){
                trees[i] += trees[j] * trees[i-j-1];
            }
        }
        return trees[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
