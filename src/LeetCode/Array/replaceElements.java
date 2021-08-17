package LeetCode.Array;

public class replaceElements {

    public static int[] replaceElements(int[] arr) {

        int max=arr[arr.length-1];
        arr[arr.length-1]=-1;
        for(int i=arr.length-2; i>=0; i--){
            int temp = arr[i];
            arr[i]=max;
            if(max<temp) max=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {};
        int[] res = replaceElements(nums);
        for(int i=0; i<res.length; i++){
            System.out.print(res[i]+",");
        }
    }
}
