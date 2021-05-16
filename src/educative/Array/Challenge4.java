package educative.Array;

import java.util.Arrays;

public class Challenge4 {
    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int [] result = new int[n];

        int prod=1;
        boolean zero_flag=false;
        for(int i=0; i<n; i++){
            if(arr[i]==0) zero_flag=true;
            else prod*=arr[i];
        }
        for(int i=0; i<n; i++){
            if(arr[i]==0) result[i] = prod;
            else result[i] = zero_flag==true? 0: prod/arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        Arrays.stream(Challenge4.findProduct(arr)).forEach(System.out::println);
    }
}
