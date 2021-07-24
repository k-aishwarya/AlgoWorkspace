package educative.String;

public class LongestPalindromicSubString {

//   Top-bottom
    static int findLPSLength(String st) {
        Integer[][] dp = new Integer[st.length()][st.length()];
        int res =  findLPSLengthRecursive(dp, st, 0, st.length() - 1);
        for(int i=0; i<st.length(); i++){
            for(int j=0; j<st.length(); j++){
                if(dp[i][j] == null) dp[i][j]=0;
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        return res;
    }

    static  int findLPSLengthRecursive(Integer[][] dp, String st, int startIndex, int endIndex) {
        if (startIndex > endIndex)
            return 0;

        // every string with one character is a palindrome
        if (startIndex == endIndex) {
            dp[startIndex][endIndex] = 1;
            return 1;
        }

        if (dp[startIndex][endIndex] == null) {
            // case 1: elements at the beginning and the end are the same
            if (st.charAt(startIndex) == st.charAt(endIndex)) {
                int remainingLength = endIndex - startIndex - 1;
                // check if the remaining string is also a palindrome
                if (remainingLength == findLPSLengthRecursive(dp, st, startIndex + 1, endIndex - 1)) {
                    dp[startIndex][endIndex] = remainingLength + 2;
                    return dp[startIndex][endIndex];
                }
            }

            // case 2: skip one character either from the beginning or the end
            int c1 = findLPSLengthRecursive(dp, st, startIndex + 1, endIndex);
            int c2 = findLPSLengthRecursive(dp, st, startIndex, endIndex - 1);
            dp[startIndex][endIndex] = Math.max(c1, c2);
        }
        return dp[startIndex][endIndex];
    }

//    Bottom-up
    static int LPS_B(String str){
        if(str==null || str.isEmpty()) return 0;
        if(str.length()<2) return 1;

        int n = str.length();
        int dp[][] = new int[n][n];

        for(int i=0; i<str.length(); i++){
            dp[i][i] = 1;
        }

        for(int i=n-1; i>=0; i--){
            for(int j=i+1; j<n; j++){
                if(str.charAt(i)==str.charAt(j)){
                    if(j-i==1 || dp[i+1][j-1]>0) {
                        dp[i][j] = Math.max(j - i + 1, dp[i + 1][j - 1]);
                    }
                }
                else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i+1][j]);
                }
            }
        }

        for(int i=0; i<str.length(); i++){
            for(int j=0; j<str.length(); j++){
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

        return dp[0][n-1];
    }



    public static void main(String[] args) {
        System.out.println(LPS_B("cddpd"));
    }


}
