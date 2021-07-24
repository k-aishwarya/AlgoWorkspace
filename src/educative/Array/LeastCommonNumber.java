package educative.Array;

public class LeastCommonNumber {

    static int findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3, int i1, int i2, int i3) {
        if(i1>=arr1.length || i2>=arr2.length || i3>=arr3.length){
            return -1;
        }

        if(arr1[i1] == arr2[i2] && arr1[i1] == arr3[i3]){
            return arr1[i1];
        }

        if(arr1[i1] <= arr2[i2] && arr1[i1] <= arr3[i3]) return findLeastCommonNumber(arr1, arr2, arr3, i1+1, i2, i3);
        else if(arr2[i2] <= arr1[i1] && arr2[i2] <= arr3[i3]) return findLeastCommonNumber(arr1, arr2, arr3, i1, i2+1, i3);
        else if(arr3[i3] <= arr1[i1] && arr3[i3] <= arr2[i2]) return findLeastCommonNumber(arr1, arr2, arr3, i1, i2, i3+1);

        return -1;
    }

    static Integer findLeastCommonNumber(int[] arr1, int[] arr2, int[] arr3) {
        return findLeastCommonNumber(arr1, arr2, arr3, 0, 0, 0);
    }

    public static void main(String[] args) {
        int[] v1 = new int[]{6, 7, 10, 25, 30, 63, 64};
        int[] v2 = new int[]{1, 4, 5, 6, 7, 8, 50};
        int[] v3 = new int[]{1, 6, 10, 14};

        Integer result = findLeastCommonNumber(v1, v2, v3);
        System.out.println("Least Common Number: " + result);
    }

}
