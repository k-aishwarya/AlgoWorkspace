package LeetCode.Array;

import java.util.Arrays;

public class heightChecker {

    public int heightChecker(int[] heights) {
        if(heights==null||heights.length<2) return 0;

        int[] expected = new int[heights.length];
        for(int i=0; i<heights.length; i++) expected[i]=heights[i];

        Arrays.sort(expected);

        int count =0;
        for(int i=0; i<heights.length; i++){
            if(heights[i]!=expected[i]) count++;
        }
        return  count;
    }

    public int heightCheckerFromSubmission(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;
    }

}
