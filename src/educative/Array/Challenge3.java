package educative.Array;

import java.util.Arrays;

public class Challenge3 {

    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        Arrays.sort(arr);
        int i=0;
        int j=arr.length-1;
        while(i<j){
            int sum = arr[i]+arr[j];
            if(sum>n) j--;
            else if (sum<n) i++;
            else{
                result[0]=arr[i];
                result[1]=arr[j];
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,21,3,14,5,60,7,6};
        Arrays.stream(Challenge3.findSum(arr,27)).forEach(System.out::print);
    }
}
