package LeetCode.Array;

public class removeDuplicates {

    public static int removeDuplicates(int[] nums) {
        int i=0;
        int cur=0;
        int res=0;
        while(cur<nums.length-1){
            if(nums[i]==nums[i+1]){
                res++;
                int k=i;
                while(k<nums.length-1){
                    nums[k]=nums[k+1];
                    k++;
                }
            }
            else{
                i++;
            }
            cur++;
        }
        return nums.length-res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int res = removeDuplicates(nums);
        for(int i=0; i<res; i++){
            System.out.print(nums[i]+",");
        }
    }
}
