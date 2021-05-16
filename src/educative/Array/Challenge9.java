package educative.Array;

import java.util.Arrays;

public class Challenge9 {
    public static void reArrange(int[] arr) {
        int last_neg = 0;
        int first_pos = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]>=0){
                if(first_pos<0)
                    first_pos = i;
            }
            if(arr[i]<0){
                last_neg=i;
            }
        }
        while(last_neg>first_pos){
            int temp = arr[last_neg];
            arr[last_neg] = arr[first_pos];
            arr[first_pos] = temp;
            while(arr[last_neg]>0)
                last_neg--;
            while(arr[first_pos]<0)
                first_pos++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,-1,6,-4,5,28,0,-3,-5,8};
        Challenge9.reArrange(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
