package LeetCode.Array;

public class sortedSquares {
    public static int[] sortedSquares(int[] nums) {

        int l =0;
        int r = nums.length-1;
        int i = nums.length-1;
        int[] res = new int[nums.length];
        while(i>=0){
            int left = nums[l]*nums[l];
            int right = nums[r]*nums[r];

            if(left>right){
                res[i--] = left;
                l++;
            }
            else{
                res[i--] = right;
                r--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        int[] res = sortedSquares(nums);
        for(int i=0; i< res.length; i++){
            System.out.print(res[i]+",");
        }
    }
}
