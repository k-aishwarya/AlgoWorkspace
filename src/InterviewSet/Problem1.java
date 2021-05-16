package InterviewSet;


import java.util.Arrays;

/*
 * Given an array and a target sum, find if there exists a pair of numbers with the sum = given target sum
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] arr = {1,5,8,2,6,3,9,4,8};
        int target = 10;

        System.out.println(brute(arr,target));
        System.out.println(usingSort(arr,target));
    }

    //Time Complexity = O(n2)
    //Space Complexity = O(1)
    public static boolean brute(int[] arr, int target){

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[i]+arr[j]==target) {
                    System.out.println(arr[i] + " " + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }

    //Time Complexity = O(nlogn)
    //Space Complexity = O(1)
    public static boolean usingSort(int[] arr, int target){
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            for(int j=arr.length-1; j>0; j--){
                if(arr[i]+arr[j]==target) {
                    System.out.println(arr[i] + " " + arr[j]);
                    return true;
                }
            }
        }
        return false;
    }

}
