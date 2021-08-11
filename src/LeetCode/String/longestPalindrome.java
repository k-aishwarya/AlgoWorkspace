package LeetCode.String;

public class longestPalindrome {

    int start=0; int maxLen=0;

    public String longestPalindrome(String s) {
        if(s==null || s.isEmpty()) return null;
        for(int i=0; i<s.length(); i++){
            maxPalindromeHelper(s,i,i);
            maxPalindromeHelper(s,i,i+1);
        }
        return s.substring(start,start+maxLen);
    }

    public void maxPalindromeHelper(String s, int i , int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            if(maxLen<j-i+1) {
                start=i;
                maxLen = j - i + 1;
            }
            i--;
            j++;
        }
    }

    public static void main(String[] args) {
        longestPalindrome l = new longestPalindrome();
        System.out.println(l.longestPalindrome("babad"));
    }
}
