package LeetCode.String;

import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()) return 0;
        Map<Character, Integer> m = new HashMap<>();
        char[] arr = s.toCharArray();
        int[] mem = new int[s.length()];
        m.put(arr[0],0);
        mem[0]=1;
        int startingIndex=0;
        for(int i=1; i<arr.length; i++){
            Integer lastMatchingIndex = m.get(arr[i]);
            if(lastMatchingIndex==null){
                mem[i]=mem[i-1]+1;
            }
            else{
                if(startingIndex>lastMatchingIndex){
                    mem[i]=i-startingIndex+1;
                }
                else{
                    mem[i]=i-lastMatchingIndex;
                    startingIndex=lastMatchingIndex+1;
                }
            }
            m.put(arr[i],i);
        }
        Integer max = Integer.MIN_VALUE;
        for(Integer i: mem){
            max = Math.max(max, i);
        }
        return max;
    }

    //From Solutions
    // Make a window using left and right
    // Use visited matrix to track the redundant chars
    public static int lengthOfLongestSubstring_(String str) {
        int[] visited = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < str.length()) {
            char r = str.charAt(right);
            visited[r]++;
            while (visited[r] > 1) {
                char l = str.charAt(left);
                visited[l]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring_("zwnigfunjwz"));
    }

}
