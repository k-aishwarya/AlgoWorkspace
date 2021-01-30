package dynamicProgramming.jan_29_21;

public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fib_2(0));
        System.out.println(fib.fib_2(1));
        System.out.println(fib.fib_2(2));
        System.out.println(fib.fib_2(3));
        System.out.println(fib.fib_2(4));
        System.out.println(fib.fib_2(5));
        System.out.println(fib.fib(6));
        System.out.println(fib.fib_2(7));
        System.out.println(fib.fib_2(8));


        System.out.println();
        System.out.println(fib.fib_1(0));
        System.out.println(fib.fib_1(1));
        System.out.println(fib.fib_1(2));
        System.out.println(fib.fib_1(3));
        System.out.println(fib.fib_1(4));
        System.out.println(fib.fib_1(5));
        System.out.println(fib.fib(6));
        System.out.println(fib.fib_1(7));
        System.out.println(fib.fib_1(8));

        //
        System.out.println();
        int[] fib_mem = new int[10];
        System.out.println(fib.fib_3(0,fib_mem));
        System.out.println(fib.fib_3(1,fib_mem));
        System.out.println(fib.fib_3(2,fib_mem));
        System.out.println(fib.fib_3(3,fib_mem));
        System.out.println(fib.fib_3(4,fib_mem));
        System.out.println(fib.fib_3(5,fib_mem));
        System.out.println(fib.fib(6));
        System.out.println(fib.fib_3(7,fib_mem));
        System.out.println(fib.fib_3(8,fib_mem));

    }


    //using down to top
    public int fib(int n){
        if(n==1 || n==0) return n;
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for(int i=2; i<n; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n-1];
    }

    //down to top ->  with memoization less space complexity
    public int fib_1(int n){
        if(n==1 || n==0) return n;
        int a=0;
        int b=1;
        int sum=0;
        for(int i=1; i<n; i++){
            sum = a+b;
            a=b;
            b=sum;
        }
        return sum;
    }

    // top to down
    public int fib_2(int n){
        if(n==1 || n==0) return n;
        return fib_2(n-1) + fib_2(n-2);
    }

    // top to down with memoization
    public int fib_3(int n, int[] fib_mem){
        if(n==1 || n==0) return n;
        if(fib_mem[n]!=0) return fib_mem[n];
        return fib_mem[n]= fib_3(n-1, fib_mem) + fib_3(n-2, fib_mem);
    }


}
