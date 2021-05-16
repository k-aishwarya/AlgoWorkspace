package dynamicProgramming.jan_30_21;

/*
    * Given an array find sum with maximum value for non contiguous subsequence.
    * Example 1 : arr = {-2,11,-4,13,-5,2} , Subsequence = {11,13,2} , Sum = 26
    * Example 2 : arr = {0,1,10,-8,-22,5,6,7,-12} , Subsequence = {0,10,5,7} , Sum = 22
 */
public class Problem9 {

    public static void main(String[] args) {

        int[] arr = {-2,11,-4,13,-5,2};
//        int[] arr = {0,1,10,-8,-22,5,6,7,-12};

        Problem9 problem9 = new Problem9();
        System.out.println(problem9.down(arr));

        int[] mem = new int[arr.length];
        System.out.println(problem9.top(arr, mem, arr.length-1));
        System.out.println();
        for(int i: mem)
            System.out.print(i+" ");


    }

    //down to top
    public int down(int[] arr){
        if(arr.length==1) return arr[0];
        int[] mem = new int[arr.length];
        mem[0] = arr[0];
        mem[1] = Math.max(arr[0],arr[1]);
        for(int i=2; i<arr.length; i++){
            mem[i] = Math.max(mem[i-1],mem[i-2]+arr[i]);
        }
        System.out.println();
        for(int i: mem)
            System.out.print(i+" ");
        System.out.println();
        return mem[arr.length-1];
    }

    //top to down
    public int top(int[] arr, int[] mem, int n){
        if(n<=0) return 0;
        if(n==arr.length-1)
            mem[n]=arr[n];
        if(n==arr.length-2)
            mem[n]=Math.max(arr[n],arr[n-1]);
        if(mem[n]!=0) return mem[n];
        return mem[n] = Math.max( top(arr, mem, n+1) , arr[n]+top(arr, mem, n+2) );
    }


}
