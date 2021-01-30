package dynamicProgramming.jan_29_21;

public class Factorial {

    public static void main(String[] args) {
        Factorial fact = new Factorial();

        System.out.println(fact.fact(0));
        System.out.println(fact.fact(1));
        System.out.println(fact.fact(2));
        System.out.println(fact.fact(3));
        System.out.println(fact.fact(4));

        System.out.println();

        System.out.println(fact.fact_1(0));
        System.out.println(fact.fact_1(1));
        System.out.println(fact.fact_1(2));
        System.out.println(fact.fact_1(3));
        System.out.println(fact.fact_1(4));

        System.out.println();

        System.out.println(fact.fact_2(0));
        System.out.println(fact.fact_2(1));
        System.out.println(fact.fact_2(2));
        System.out.println(fact.fact_2(3));
        System.out.println(fact.fact_2(4));

        System.out.println();

        int[] factMem = new int[10];
        System.out.println(fact.fact_3(0, factMem));
        System.out.println(fact.fact_3(1, factMem));
        System.out.println(fact.fact_3(2, factMem));
        System.out.println(fact.fact_3(3, factMem));
        System.out.println(fact.fact_3(4, factMem));

        System.out.println();

    }

    // down to top
    int fact(int n){
        if(n==0 || n==1) return 1;
        int[] fact = new int[n+1];
        fact[0]=1;
        fact[1]=1;
        for(int i=1;i<=n;i++){
            fact[i]=fact[i-1]*i;
        }
        return fact[n];
    }

    // down to top -> optimised space complexity
    int fact_1(int n){
        if(n==0 || n==1) return 1;
        int[] fact = new int[n+1];
        int factVal=1;
        for(int i=1;i<=n;i++){
            factVal = i*factVal;
        }
        return factVal;
    }

    //top to down --> no  memoization
    int fact_2(int n){
        if(n==0 || n==1) return 1;
        return fact_2(n-1)*n;
    }

    //top to down --> memoization
    int fact_3(int n, int[] factMem){
        if(n==0 || n==1) return 1;
        if(factMem[n]!=0) return factMem[n];
        return factMem[n] = fact_3(n-1, factMem)*n;
    }
}
