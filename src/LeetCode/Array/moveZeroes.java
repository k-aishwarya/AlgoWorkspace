package LeetCode.Array;

public class moveZeroes {

    public static void moveZeroes(int[] nums) {
        if(nums==null || nums.length<2) return;
        int writer=0;
        for(int reader=1; reader<nums.length; reader++){
            if(nums[writer]==0 && nums[reader]!=0){
                nums[writer] = nums[reader];
                nums[reader]=0;
                writer++;
            }
            else if(nums[writer]!=0){
                writer++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums= {0,1,0,3,12,0,0,0,5,6,7,0,9,8};
        moveZeroes(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i]+",");
        }
    }


}
