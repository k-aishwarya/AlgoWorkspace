package PractiseKarumanchi.BacktrackingRecursion;

// Find size of biggest island (max block connected by 1s)
public class IslandProblem{

    public static void display(boolean[][] a){
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getMaxSize(int[][] a, boolean[][] visited, int i, int j, int row, int col){
        if(i>=row || j>=col || i<0 || j<0) return 0;
        if(visited[i][j] == true || a[i][j]!=1) return 0;
        visited[i][j] = true;
        int[][] directions = {
                {-1,-1},
                {-1,0},
                {-1,1},
                {0,1},
                {1,1},
                {1,0},
                {1,-1},
                {0,-1}
        };

        int size = 1;

        for(int k=0; k<directions.length; k++){
            int[] direction = directions[k];
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            size += getMaxSize(a, visited, new_i, new_j, row, col);
        }
        return size;
    }




    public static void main(String[] args) {

        int row = 5;
        int col = 5;
        int[][] a = {
                    {1,1,0,0,0},
                    {0,1,1,0,0},
                    {0,0,1,0,1},
                    {1,0,0,0,1},
                    {0,1,0,1,1}
                    };

        boolean[][] visited = new boolean[row][col];

        display(visited);

    }

}