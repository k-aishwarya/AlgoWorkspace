package educative.Array;

import java.util.Arrays;

public class Challenge5 {
    public static int findMinimum(int[] arr) {
        if(arr.length<=0) return 0;
        int min = arr[0];
        for(int i=0; i< arr.length; i++){
            if(min>arr[i]) min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        System.out.println(Challenge5.findMinimum(arr));
    }

}
