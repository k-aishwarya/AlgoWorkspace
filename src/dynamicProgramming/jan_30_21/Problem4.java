package dynamicProgramming.jan_30_21;

/*
 * Maximum Value Contiguous Subsequence:
 * Given an array of n numbers, find max sum for Contiguous Subsequence
 * Example:
 *  Input -> {-2,11,-4,13,-5,2};  Maximum Value Contiguous Subsequence -> {11,-4,13}; Output -> 20
 *  Input -> {1,-3,4,-2,-1,6};  Maximum Value Contiguous Subsequence -> {4,-2,-1,6}; Output -> 7
 *
 * Problem 4,5,6,7,8
 */
public class Problem4 {

    public static void main(String[] args) {

        int[] arr = {-2,11,-4,13,-5,2};

        Problem4 problem4 = new Problem4();
        System.out.println(problem4.brute_force(arr));
        System.out.println(problem4.brute_force_1(arr));
        System.out.println(problem4.dp(arr));
    }

    // Complexity - O(n3)
    int brute_force(int[] arr){
        int n = arr.length;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int curSum = 0;
                for(int k=i; k<=j; k++){
                    curSum+=arr[k];
                }
                if (max<curSum) max=curSum;
            }
        }
        return max;
    }

    // Complexity - O(n2)
    int brute_force_1(int[] arr){
        int n = arr.length;
        int max = 0;
        for(int i=0;i<n;i++){
            int curSum = 0;
            for(int j=i;j<n;j++){
                curSum+=arr[j];
                if (max<curSum) max=curSum;
            }
        }
        return max;
    }

    // DP - Complexity - O(n)
    int dp(int[] arr){
        int[] mem = new int[arr.length];
        if(arr[0]>0) mem[0]=arr[0];
        else mem[0]=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]+mem[i-1]>0) mem[i] = arr[i]+mem[i-1];
            else mem[i]=0;
        }
        int max=0;
        for(int i=0;i<mem.length;i++){
            if(max<mem[i]) max=mem[i];
        }
        return max;
    }
}
