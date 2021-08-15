package LeetCode.Array;

import java.util.*;

public class threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<3) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                System.out.println(1);
                if(l!=i+1 && nums[l]==nums[l-1]){
                    l++;
                    continue;
                }
                if(r!=nums.length-1 && nums[r]==nums[r+1]){
                    r--;
                    continue;
                }
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> list = Arrays.asList(nums[i],nums[l],nums[r]);
                    res.add(list);
                    l++;
                    r--;
                }
                else if(sum<0){
                    l++;
                }
                else{
                    r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        System.out.println(threeSum(nums));
    }
}
