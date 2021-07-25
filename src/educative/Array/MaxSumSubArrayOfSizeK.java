package educative.Array;

public class MaxSumSubArrayOfSizeK {

    public static int findMaxSumSubArray(int k, int[] arr) {
        if(arr == null || arr.length<k)
            return -1;

        int curSum=0;
        for(int i=0; i<k; i++){
            curSum += arr[i];
        }

        int max=curSum;
        for(int i=k; i<arr.length; i++){
            curSum = curSum + arr[i] - arr[i-k];
            if(max<curSum) max = curSum;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}
