package LeetCode.Array;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
public class subarraySum {

    // Complexity O(n)
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int count=0;
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(sum==k) count++;

            if(m.get(sum-k)!=null){
                count += m.get(sum-k);
            }

            m.put(sum, m.getOrDefault(sum,0)+1);
        }
        return count;
    }

    // Complexity O(n3)
    public static int subarraySum2(int[] nums, int k) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            for(int j=i; j<nums.length; j++){
                int sum=0;
                for(int l=i; l<=j; l++){
                    sum += nums[l];
                }
                if(sum==k) count++;
            }
        }
        return count;
    }

    // Complexity O(n2)
    public static int subarraySum3(int[] nums, int k) {
        int count=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {0, -1, 1, -2, 1, 2, -1};
        System.out.println(subarraySum3(arr,0));
    }

}
