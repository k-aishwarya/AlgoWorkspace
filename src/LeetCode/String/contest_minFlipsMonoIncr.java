package LeetCode.String;

public class contest_minFlipsMonoIncr {
    public static int minFlipsMonoIncr(String s) {
        if(s==null || s.isEmpty()) return 0;
        char[] arr = s.toCharArray();
        int zeroes=0;
        int ones=0;
        int balance=0;
        int maxBalance=0;
        int maxBalanceIndex=0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]=='1') balance--;
            else balance++;

            // System.out.println(balance);
            if(maxBalance<=balance) {
                maxBalance=balance;
                maxBalanceIndex=i;
            }
        }

        // System.out.println(maxBalanceIndex);

        if(arr[maxBalanceIndex]=='1') maxBalanceIndex--;
        int flipOnes=0;
        int flipZeroes=0;
        for (int i=0;i<=maxBalanceIndex;i++){
            if(arr[i] =='1') flipOnes++;
        }

        for(int i=maxBalanceIndex+1;i<arr.length;i++){
            if(arr[i]=='0') flipZeroes++;
        }
        return flipOnes+flipZeroes;
    }

    public static void main(String[] args) {
        System.out.println(minFlipsMonoIncr("10011111110010111011"));
    }
}
