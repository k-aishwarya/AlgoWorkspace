package LeetCode.Array;

public class nextPermutation {

    public static void nextPermutation(int[] nums) {
        if(nums==null||nums.length<2) return;
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            int j=nums.length-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        rotate(nums,i+1, nums.length-1);
    }

    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void rotate(int[] nums, int i, int j){
        while(i<=j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+",");
        }
    }
}
