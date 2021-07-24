package educative.Array;

public class CyclicSort {

    public static void sort(int[] nums) {
        for(int i=0; i<nums.length; i++){
            nums[i]=i+1;
        }
    }

    //Second way
    public static void sort1(int[] nums) {
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            nums[i]=i+1;
            nums[n-1]=n;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2,6,1};
        sort1(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] +" ");
        }
    }


}
