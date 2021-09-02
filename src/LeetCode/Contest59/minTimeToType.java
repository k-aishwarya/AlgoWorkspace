package LeetCode.Contest59;

public class minTimeToType {
    public static int minTimeToType(String word) {
        if(word==null || word.length()<1) return 0;
        if(word.length()==1) return 1;
        char[] arr = word.toCharArray();
        int res = 0;
        char prev = 'a';
        for(char c: arr){
            if(prev!=c) {
                if (Math.abs(prev - c) > 13) {
                    res += 26 - Math.abs(prev - c);
                } else {
                    res += Math.abs(prev - c);
                }
            }
            prev=c;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToType("zjpc"));
    }

}
