package educative.Array;

import java.util.*;

public class Challenge10  {

    public static void maxMin(int[] arr) {

        Deque<Integer> q = new LinkedList<>();
        Arrays.stream(arr).forEach(q::add);
        System.out.println();
        for(int i=0; i<arr.length; i++){
            if(i%2==0) arr[i] = q.removeLast();
            else arr[i] = q.removeFirst();
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void maxMin_2(int[] arr) {
        int maxIdx = arr.length - 1;
        int minIdx = 0;
        int maxElem = arr[maxIdx] + 1; // store any element that is greater than the maximum element in the array
        for( int i = 0; i < arr.length; i++) {
            // at even indices we will store maximum elements
            if (i % 2 == 0){
                arr[i] += (arr[maxIdx] % maxElem ) * maxElem;
                maxIdx -= 1;
            }
            else { // at odd indices we will store minimum elements
                arr[i] += (arr[minIdx] % maxElem ) * maxElem;
                minIdx += 1;
            }
        }

        for(int i=0; i< arr.length;i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
        // dividing with maxElem to get original values.
        for( int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxElem;
        }

        Arrays.stream(arr).forEach(System.out::print);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Challenge10.maxMin_2(arr);
    }
}
