package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null||nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0; i<nums.length-3; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j<nums.length-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int l = j+1;
                int r = nums.length-1;
                while(l<r){
                    if(l!=j+1 && nums[l]==nums[l-1]) {
                        l++;
                        continue;
                    }
                    if(r!=nums.length-1 && nums[r]==nums[r+1]) {
                        r--;
                        continue;
                    }
                    int sum = nums[i]+nums[j]+nums[l]+nums[r];
                    if(sum==target){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                        res.add(list);
                        l++;
                        r--;
                    }
                    else if(sum<target) l++;
                    else r--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums,8));
    }
}
