package LeetCode.String;

import java.util.ArrayList;
import java.util.List;

public class contest_makeFancyString {
    public static String makeFancyString(String s) {
        if(s.length()<2) return s;
        List<Character> chars = new ArrayList<>();

        for (char ch : s.toCharArray()) {
            chars.add(ch);
        }
        int i=0;
        int j=2;
        int len=s.length();
        while(j<len){
            if(chars.get(i)==chars.get(i+1) && chars.get(i+1)==chars.get(j)){
                chars.remove(i);
                len--;
            }
            else{
                i++;
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }

    //Optimized
    public static String makeFancyString_2(String s) {
        if(s.length()<2) return s;
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<arr.length-1){
            if(arr[i]==arr[i+1]) {
                while (i < arr.length-1 && arr[i] == arr[i + 1]) {
                    i++;
                }
                sb.append(arr[i]);
                sb.append(arr[i]);
                i++;
            }
            else{
                sb.append(arr[i]);
                i++;
            }
        }
        if(i==arr.length-1) sb.append(arr[i]);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(makeFancyString_2("aaabaaaa"));
    }
}
