package LeetCode.Array;

public class maxSubArray {

    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length<1) return 0;
        int total_max=nums[0];
        for(int i: nums){
            total_max=Math.max(i,total_max);
        }
        if(total_max<0) return total_max;
        int cur = Math.max(0,nums[0]);
        for(int i=1; i<nums.length; i++){
            if(cur+nums[i]<0){
                cur=0;
            }
            else{
                cur+=nums[i];
            }
            total_max=Math.max(cur,total_max);
        }
        return total_max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-1};
        System.out.println(maxSubArray(nums));
    }
}
