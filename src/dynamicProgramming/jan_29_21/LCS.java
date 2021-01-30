package dynamicProgramming.jan_29_21;

public class LCS {

    public static void main(String[] args) {
        String X = "ABCBDAB";
        String Y = "BDCABA";
        int[][] lcsMem = new int[1024][1024];

        LCS lcsObj = new LCS();
        System.out.println(lcsObj.lcs(X,Y,lcsMem));
    }

    int lcs(String X, String Y, int[][] lcsMem){
        int x = X.length();
        int y = Y.length();

        for(int i=x-1; i>=0 ;i--){
            for(int j=y-1; j>=0; j--){
                lcsMem[i][j] = lcsMem[i+1][j+1];
                if(X.charAt(i)==Y.charAt(j)){
                    lcsMem[i][j]++;
                }
                lcsMem[i][j] = Math.max(lcsMem[i][j], lcsMem[i + 1][j]);
                lcsMem[i][j] = Math.max(lcsMem[i][j], lcsMem[i][j+1]);
            }
        }
        return lcsMem[0][0];
    }
}
