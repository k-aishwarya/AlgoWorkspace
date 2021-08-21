package LeetCode.Array;

public class removeElementBetter {

    public static int removeElement(int[] nums, int val) {
        int writer=0;
        for(int reader=0; reader<nums.length; reader++){
            if(nums[writer]==val && nums[reader]!=val){
                int temp = nums[writer];
                nums[writer] = nums[reader];
                nums[reader] = temp;
                writer++;
            }
            else if(nums[writer]!=val) writer++;
        }
        return writer;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,4,4,5,6,5,5};
        int res = removeElement(nums,5);
        for(int i=0; i< res; i++){
            System.out.print(nums[i]+",");
        }
    }
}
