package InterviewSet;

import java.util.Arrays;
import java.util.HashSet;

/*
 * Given an array and a target sum, find if there exists a trio of numbers with the sum = given target sum
 */
public class Problem2 {
    public static void main(String[] args) {
        int[] arr = {1,5,8,2,12,3,9,4,11};
        int target = 10;

        System.out.println(brute(arr,target));
        System.out.println(usingSort(arr,target));
        System.out.println(hashingTechnique(arr,target));
    }

    //Time Complexity = O(n3)
    //Space Complexity = O(1)
    public static boolean brute(int[] arr, int target){

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                for(int k=j+1; k<arr.length; k++){
                    if(arr[i]+arr[j]+arr[k]==target) {
                        System.out.println(arr[i] + " " + arr[j]+ " " + arr[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //Time Complexity = O(n2)
    //Space Complexity = O(1)
    public static boolean usingSort(int[] arr, int target){
        Arrays.sort(arr);
        int l,r;
        for(int i=0; i<arr.length-2; i++){
            l = i+1;
            r = arr.length-1;
            while(l<r){
                if (arr[i] + arr[l] + arr[r] == target) {
                    System.out.println(arr[i] + " " + arr[l]+ " " + arr[r]);
                    return true;
                }
                else if (arr[i] + arr[l] +arr[r] < target)
                    l++;

                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        return false;
    }

    //Time Complexity = O(n2)
    //Space Complexity = O(n)
    public static boolean hashingTechnique(int[] arr, int target){
        for(int i=0; i<arr.length-2; i++){
            HashSet<Integer> s = new HashSet<>();
            int cur_sum = target-arr[i];
            for(int j=i+1; j<arr.length-1; j++){
                if (s.contains(cur_sum - arr[j])) {
                    System.out.println(arr[i] + " " + arr[j]+ " " + (cur_sum - arr[j]));
                    return true;
                }
                else {
                    s.add(arr[j]);
                }
            }
        }
        return false;
    }


}
