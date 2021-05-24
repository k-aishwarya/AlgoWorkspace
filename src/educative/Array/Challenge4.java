package educative.Array;

import java.util.Arrays;

public class Challenge4 {
    public static int[] findProduct(int arr[])
    {
        int n = arr.length;
        int [] result = new int[n];

        int prod=1;
        int zero_count = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==0) zero_count++;
            else prod*=arr[i];
        }
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                if(zero_count==1)
                    result[i] = prod;
                else
                    result[i] = 0;
            }
            else result[i] = zero_count>0? 0: prod/arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,0,0};
        Arrays.stream(Challenge4.findProduct(arr)).forEach(System.out::println);
    }
}
