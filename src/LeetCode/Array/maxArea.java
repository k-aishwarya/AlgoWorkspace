package LeetCode.Array;

public class maxArea {

    public static int maxArea(int[] height) {
        if(height==null || height.length<2) return 0;
        int maxArea = Integer.MIN_VALUE;

        int l=0;
        int r = height.length-1;
        while(l<r){
            maxArea=Math.max((r-l)*Math.min(height[l],height[r]), maxArea);
            if(height[l]<height[r]) l++;
            else r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
