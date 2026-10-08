class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix.length;

        for(int row = 0; row <rows;row++){
            for(int col = row;col<cols;col++){
                int temp = matrix[row][col];

                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }

        int left = 0;
        int right = rows-1;

        while(left < right){
            for(int row=0;row < rows;row++){
                int temp = matrix[row][left];

                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
            left++;
            right--;
        }
    }
}
