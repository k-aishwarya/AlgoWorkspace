package LeetCode.Array;

public class duplicateZeros {

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,7,6,0,2,0,7};
        duplicateZeros(nums);
        for(int i=0; i< nums.length; i++){
            System.out.print(nums[i]+",");
        }
    }
}
