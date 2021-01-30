package dynamicProgramming.jan_30_21;


/*
    * Convert following recurrence to code:
    * T(0)=T(1)=2
    * T(n) = ∑ 2*T(i)*T(i-1) , for n>1 , i>=1 , i<n
    *
    * Problem 1,2,3
 */

//T(2) = 2*T(0)*T(1)
//T(3) = T(2) + 2*T(1)*T(2)
//T(4) = T(3) + 2*T(2)*T(3)


public class Problem1 {

    public static void main(String[] args) {
        Problem1 prob = new Problem1();

        int n = 6;

        Long start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            System.out.println(prob.down_rec(i));
        }
        Long end = System.currentTimeMillis();
        Long total = end-start;
        System.out.println("Time="+total);
        System.out.println("+++++++++++++++++++++++++++");

        start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            System.out.println(prob.down_rec_1(i));
        }
        end = System.currentTimeMillis();
        total = end-start;
        System.out.println("Time="+total);
        System.out.println("+++++++++++++++++++++++++++");

        start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            System.out.println(prob.top_rec(i));
        }
        end = System.currentTimeMillis();
        total = end-start;
        System.out.println("Time="+total);
        System.out.println("+++++++++++++++++++++++++++");

        start = System.currentTimeMillis();
        for(int i=0;i<n;i++){
            System.out.println(prob.top_rec_1(i, new int[100]));
        }
        end = System.currentTimeMillis();
        total = end-start;
        System.out.println("Time="+total);
        System.out.println("+++++++++++++++++++++++++++");
    }

    //down to top -- space complexity optimized
    int down_rec(int n){
        if(n==0||n==1) return 2;
        int a=2;
        int b=2;
        int result = 0;
        for(int i=2; i<=n; i++){
            result += 2*a*b;
            a=b;
            b=result;
        }
        return result;
    }

    //down to top
    int down_rec_1(int n){
        if(n==0||n==1) return 2;
        int[] mem = new int[n+1];
        mem[0]=2;
        mem[1]=2;
        int sum = 0;
        for(int i=2; i<=n; i++){
            sum += 2*mem[i-1]*mem[i-2];
            mem[i] = sum;
        }
        return mem[n];
    }

    //top to down -- no memoization
    int top_rec(int n){
        if(n==0||n==1) return 2;
        if(n==2) return 8;
        int a = top_rec(n-1);
        int b = top_rec(n-2);
        return a + 2*a*b;
    }

    //top to down -- memoization
    int top_rec_1(int n, int[] mem){
        if(n==0||n==1) return 2;
        if(n==2) return 8;
        if(mem[n]!=0) return mem[n];
        return mem[n] = top_rec_1(n-1, mem) + 2*top_rec_1(n-1, mem)*top_rec_1(n-2, mem);
    }
}
