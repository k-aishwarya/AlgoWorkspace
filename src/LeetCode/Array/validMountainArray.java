package LeetCode.Array;

public class validMountainArray {

    public static boolean validMountainArray(int[] arr) {
        int i=0;
        while(i<arr.length-1 && arr[i]<arr[i+1]){
            i++;
        }
        if(i==0 || i==arr.length-1 || (i<arr.length-1 && arr[i]==arr[i+1])) return false;
        while(i<arr.length-1 && arr[i]>arr[i+1]){
            i++;
        }
        return i==arr.length-1;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,5};
        System.out.println(validMountainArray(nums));
    }

}
