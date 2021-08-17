package LeetCode.Array;

public class merge {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur=0;
        int j=0;
        int i=0;
        while(i<m){
            if(j<n && nums1[cur]>nums2[j]){
                int k = nums1.length - 1;
                while (k > cur) {
                    nums1[k] = nums1[k - 1];
                    k--;
                }
                nums1[cur]=nums2[j];
                j++;
            }
            else{
                i++;
            }
            cur++;
        }
        while(j<n){
            nums1[cur++]=nums2[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        merge(nums1,0,nums2,1);
        for(int i=0; i< nums1.length; i++){
            System.out.print(nums1[i]+",");
        }
    }

}
