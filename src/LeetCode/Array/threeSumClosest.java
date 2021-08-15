package LeetCode.Array;

import java.util.Arrays;

public class threeSumClosest {

    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length<3) return 0;
        Arrays.sort(nums);
        int minDistance = Integer.MAX_VALUE;
        int resSum=0;
        for(int i=0; i<nums.length-2; i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return target;
                }
                else if(sum<target){
                    if(minDistance>Math.abs(target-sum)){
                        minDistance=Math.abs(target-sum);
                        resSum=sum;
                    }
                    l++;
                }
                else{
                    if(minDistance>Math.abs(target-sum)){
                        minDistance=Math.abs(target-sum);
                        resSum=sum;
                    }
                    r--;
                }
            }
        }
        return resSum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSumClosest(nums,1));
    }
}
