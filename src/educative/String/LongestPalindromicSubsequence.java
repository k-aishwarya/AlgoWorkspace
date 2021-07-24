package educative.String;

public class LongestPalindromicSubsequence {


    static String palindrome(String str, int[][] M){
        String rev = new StringBuilder(str).reverse().toString();
        StringBuilder result = new StringBuilder();
        int n = str.length();
        int k=0;
        int m=0;
        while(k<n || m<n)
        {
            if(str.charAt(k)==rev.charAt(m)){
                System.out.println(str.charAt(k));
                result.append(str.charAt(k));
                m++;
                k++;
            }
            else{
                if(M[k+1][m+1]>M[k+1][m] && M[k+1][m+1]>M[k][m+1]) {
                    m++;
                    k++;
                }
                else if(M[k][m+1]>M[k+1][m] && M[k][m+1]>M[k+1][m+1]){
                    m++;
                }
                else if(M[k+1][m]>M[k][m+1] && M[k+1][m]>M[k+1][m+1]){
                    k++;
                }
            }
        }
        return result.toString();
    }

//    Bottom Up approach
    static int LPS(String str){
        String rev = new StringBuilder(str).reverse().toString();
        int n = str.length();
        int M[][] = new int[n+1][n+1];
        for(int i=n-1 ; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                M[i][j] = M[i+1][j+1];
                if(str.charAt(i)==rev.charAt(j)){
                    M[i][j]+=1;
                }

                if(M[i][j]<M[i][j+1]) {
                    M[i][j]=M[i][j+1];
                }
                if(M[i][j]<M[i+1][j]) {
                    M[i][j]=M[i+1][j];
                }
            }

        }

        for(int k=0; k<n+1; k++){
            for(int m=0; m<n+1; m++){
                System.out.print(M[k][m]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();

        return M[0][0];
    }


//    Top Down Approach
    static int LPS_top(String str, int[][]M ,int i, int j){
        if(j<0 || i>str.length()-1) return 0;
        if(str.charAt(i)==str.charAt(j)) {
            M[i][j] = 1 + LPS_top(str, M, i + 1, j - 1);
        }
        else{
            int c1 = LPS_top(str, M, i, j-1);
            int c2 = LPS_top(str, M, i+1, j);
            M[i][j] = Math.max(Math.max(c1,c2),M[i][j]);
        }
        return M[i][j];
    }

    static int LPS_top(String str){
        int[][] M = new int[str.length()+1][str.length()+1];
        int res = LPS_top(str, M, 0, str.length()-1);
        for(int k=0; k<str.length()+1; k++){
            for(int m=0; m<str.length()+1; m++){
                System.out.print(M[k][m]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
        return res;
    }

    public static void main(String[] args) {
        String str = "abdbca";
        System.out.println(LPS(str));
        System.out.println(LPS_top(str));
    }


}
