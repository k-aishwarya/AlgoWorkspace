package educative.Array;

import java.util.Arrays;
import java.util.List;

public class FindLowHigh {

    static int binarySearchLow(List<Integer> arr, int key){
        if(arr==null || arr.size()==0) return -1;
        int l = 0;
        int r = arr.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid) == key) {
                if(mid>0){
                    if(arr.get(mid-1)==key) r = mid-1;
                    else return mid;
                }
                else return mid;
            }
            else if(arr.get(mid)<key){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    static int binarySearchHigh(List<Integer> arr, int key){
        if(arr==null || arr.size()==0) return -1;
        int l = 0;
        int r = arr.size()-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(arr.get(mid) == key) {
                if(mid<arr.size()-1){
                    if(arr.get(mid+1)==key) l = mid+1;
                    else return mid;
                }
                else return mid;
            }
            else if(arr.get(mid)<key){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return -1;
    }

    static int findLowIndex(List<Integer> arr, int key) {
        return binarySearchLow(arr,key);
    }

    static int findHighIndex(List<Integer> arr, int key) {
        return binarySearchHigh(arr,key);
    }

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4,4, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        int key = 2;
        int low = findLowIndex(array, key);
        int high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);

        key = -2;
        low = findLowIndex(array, key);
        high = findHighIndex(array, key);
        System.out.println("Low Index of " + key + ": " + low);
        System.out.println("High Index of " + key + ": " + high);
    }
}
