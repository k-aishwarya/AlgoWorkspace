package LeetCode.Array;

public class sortArrayByParity {

    public static int[] sortArrayByParity(int[] nums) {
        int writer=0;
        for(int reader=1; reader<nums.length; reader++){
            if(nums[writer]%2!=0 && nums[reader]%2==0){
                int temp = nums[writer];
                nums[writer] = nums[reader];
                nums[reader] = temp;
                writer++;
            }
            else if(nums[writer]%2==0){
                writer++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3};
        nums = sortArrayByParity(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+",");
        }
    }
}
