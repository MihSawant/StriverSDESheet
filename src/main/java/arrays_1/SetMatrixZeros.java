package arrays_1;

import java.util.Arrays;

/*
    [[],[],[]]
    {1,1,1},
    {1,0,1},
    {1,1,1}

    [[0,1,2,0],[],[]]
    {0, 1, 2, 0},
    {3,4,5,2},
    {1,3,1,5}
 */
public class SetMatrixZeros {
    public static void main(String[] args) {

        new Solution().setZeroes(new int[][]{
                {1, 1, 1, 0},
                {1, 1, 0, 1},
                {3, 4, 2, 4}
        });
    }
}

class Solution {

    int[][] matrix;

//    private void markColumn(int col){
//        for(int row = 0; row < matrix.length; row++){
//            if(matrix[row][col] != 0) matrix[row][col] = -1;
//        }
//
//    }
//    private void markRow(int row){
//        for(int col = 0; col < matrix.length; col++){
//            if(matrix[row][col] !=0) matrix[row][col] = -1;
//        }
//    }

    // this function takes params rows and cols array and set zeros in original matrix
    private void makeZeros(int[] rows, int[] cols){
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < cols.length; j++){
                if(rows[i] == 1 || cols[j] == 1) matrix[i][j] = 0;
            }
        }
    }

    // helper function, for printing array
    private void printArray(){
        for(int[] row : matrix){
            System.out.println(Arrays.toString(row));
        }
    }




    public void setZeroes(int[][] matrix) {
        this.matrix = matrix;
        // keep row count for 0 in row
        int[] rowsCount = new int[matrix.length];
        // keep col count for 0 in col
        int[] colsCount = new int[matrix[0].length];


       for(int row = 0; row < matrix.length; row++){
          for(int col = 0; col < matrix[row].length; col++){

              if(matrix[row][col] == 0) {
                // mark 1 so to change entire row or col to 0
                rowsCount[row] = 1;
                colsCount[col] = 1;
              }
          }
       }
        makeZeros(rowsCount, colsCount);
        printArray();
    }

}
