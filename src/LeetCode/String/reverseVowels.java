package LeetCode.String;

public class reverseVowels {
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int l=0;
        int r=arr.length-1;
        while(l<r){
            if(isVowel(arr[l])&&isVowel(arr[r])){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
            else if(!isVowel(arr[l])){
                l++;
            }
            else if(!isVowel(arr[r])){
                r--;
            }
        }
       return  String.valueOf(arr);
    }

    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
