package LeetCode.Array;

public class removeElement {
    public static int removeElement(int[] nums, int val) {

        int i=0;
        int res=0;
        int cur=0;
        while(cur<nums.length){
            if(nums[i]==val){
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
        int[] nums = {0,1,2,2,3,0,4,2};
        int res = removeElement(nums,2);
        for(int i=0; i<res; i++){
            System.out.print(nums[i]+",");
        }
    }
}
