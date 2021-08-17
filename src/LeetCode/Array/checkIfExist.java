package LeetCode.Array;

import java.util.HashSet;
import java.util.Set;

public class checkIfExist {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> s = new HashSet<>();
        for(int i=0; i<arr.length; i++){
            if(s.contains(arr[i]*2) || (arr[i]%2==0 && s.contains(arr[i]/2))) return true;
            s.add(arr[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(checkIfExist(arr));
    }
}
