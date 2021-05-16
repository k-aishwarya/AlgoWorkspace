package educative.String;

public class PalindromeSubStrings2 {

    public static int findAllPalindromeSubstrings(String input, int j, int k){
        int count =0;
        for(; j>=0 && k<input.length(); j--, k++){
            if(input.charAt(j)!=input.charAt(k)){
                return count;
            }
            count++;
        }
        return count;
    }

    public static int findAllPalindromeSubstrings(String input) {
        int count = 0;
        for (int i=0; i<input.length(); i++){
            count += findAllPalindromeSubstrings(input, i-1,i+1);
            count += findAllPalindromeSubstrings(input, i,i+1);
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "aabbbaa";
        int count = findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + count);
    }
}
