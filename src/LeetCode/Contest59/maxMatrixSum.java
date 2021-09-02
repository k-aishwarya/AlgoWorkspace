package LeetCode.Contest59;

public class maxMatrixSum {
    public static long maxMatrixSum(int[][] matrix) {

        long abs_sum = 0;
        long abs_min = Long.MAX_VALUE;
        long count_negatives = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]<0) count_negatives++;
                abs_sum+=Math.abs(matrix[i][j]);
                abs_min=Math.min(abs_min,Math.abs(matrix[i][j]));
            }
        }
        if(count_negatives%2==0){
            return abs_sum;
        }
        else{
            return abs_sum-2*abs_min;
        }
    }

    public static void main(String[] args) {
        int[][] matrix =
                {{1,2,3},
                {-1,-2,-3},
                {1,2,3}};

        System.out.println(maxMatrixSum(matrix));
    }
}
