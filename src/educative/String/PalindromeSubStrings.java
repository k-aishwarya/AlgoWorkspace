package educative.String;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubStrings {

    public static boolean isPalindrome(String input){
        int i=0; int j=input.length()-1;
        while(i<j){
            if(input.charAt(i)!=input.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static int findAllPalindromeSubstrings(String input) {
        Set<String> palindromes = new HashSet<>();
        int count = 0;
        for(int i=0; i<input.length(); i++){
            for (int j=i+1; j<input.length(); j++){
                String sub = input.substring(i,j+1);
                if(palindromes.contains(sub) || isPalindrome(sub)){
                    System.out.println(sub);
                    palindromes.add(sub);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + count);
    }
}
