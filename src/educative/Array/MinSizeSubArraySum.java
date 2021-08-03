package educative.Array;

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        if(arr==null || arr.length==0)
            return -1;

        int minLength=Integer.MAX_VALUE;
        int curSum=0;
        int windowStart = 0;
        for(int windowEnd=0; windowEnd<arr.length; windowEnd++){
            curSum += arr[windowEnd];
            while(curSum>=S){
                minLength = Math.min(minLength, windowEnd-windowStart+1);
                curSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }
    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}
