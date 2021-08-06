package LeetCode.Array;

public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    public static int binarySearch(int[] nums, int target, int low, int high){
        if(low>high){
            return low;
        }
        int mid = (low+high)/2;
        if(nums[mid]==target) {
            return mid;
        }
        else if (nums[mid]>target){
            return binarySearch(nums, target, low, mid-1);
        }
        else{
            return binarySearch(nums, target, mid+1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }
}
