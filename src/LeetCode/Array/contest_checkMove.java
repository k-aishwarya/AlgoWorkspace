package LeetCode.Array;

public class contest_checkMove {
    public static boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        char endcolor = color;
        char midcolor = endcolor=='W'? 'B':'W';

        int maxSize = 7;

        //top
        int i=rMove;
        int j=cMove;
        if(i>0){
           i--;
           if(board[i][j]==midcolor) {
               while (i>0 && board[i][j] == midcolor) {
                   i--;
               }
               if(board[i][j]==endcolor){
                   return true;
               }
           }
        }

        //right
        i=rMove;
        j=cMove;
        if(j<maxSize){
            j++;
            if(board[i][j]==midcolor) {
                while (j<maxSize && board[i][j] == midcolor) {
                    j++;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //bottom
        i=rMove;
        j=cMove;
        if(i<maxSize){
            i++;
            if(board[i][j]==midcolor) {
                while (i<maxSize && board[i][j] == midcolor) {
                    i++;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //left
        i=rMove;
        j=cMove;
        if(j>0){
            j--;
            if(board[i][j]==midcolor) {
                while (j>0 && board[i][j] == midcolor) {
                    j--;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //diagonal-top-left
        i=rMove;
        j=cMove;
        if(j>0&&i>0){
            j--;
            i--;
            if(board[i][j]==midcolor) {
                while (j>0&&i>0 && board[i][j] == midcolor) {
                    j--;
                    i--;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //diagonal-top-right
        i=rMove;
        j=cMove;
        if(j<maxSize&&i>0){
            j++;
            i--;
            if(board[i][j]==midcolor) {
                while (j<maxSize&&i>0 && board[i][j] == midcolor) {
                    j++;
                    i--;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //diagonal-bottom-right
        i=rMove;
        j=cMove;
        if(j<maxSize&&i<maxSize){
            j++;
            i++;
            if(board[i][j]==midcolor) {
                while (j<maxSize&&i<maxSize && board[i][j] == midcolor) {
                    j++;
                    i++;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        //diagonal-bottom-left
        i=rMove;
        j=cMove;
        if(j>0&&i<maxSize){
            j--;
            i++;
            if(board[i][j]==midcolor) {
                while (j>0&&i<maxSize && board[i][j] == midcolor) {
                    j--;
                    i++;
                }
                if(board[i][j]==endcolor){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] boards = {
        {'.','.','.','.','W','B','B','B'},
        {'.','.','.','.','.','.','.','B'},
        {'W','.','.','W','.','.','W','.'},
        {'B','.','B','B','B','.','.','W'},
        {'W','.','.','B','W','B','B','.'},
        {'W','B','.','.','W','B','B','.'},
        {'.','W','B','B','W','B','.','W'},
        {'B','.','W','B','W','.','W','.'}};

        System.out.println(checkMove(boards, 0,0,'B'));

    }

}
