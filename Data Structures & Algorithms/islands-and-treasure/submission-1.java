class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    updateGrid(grid,i,j+1,1);
                    updateGrid(grid,i,j-1,1);
                    updateGrid(grid,i+1,j,1);
                    updateGrid(grid,i-1,j,1);
                }
            }
        }
    }

    private void updateGrid(
        int[][] grid,
        int row,
        int col,
        int currDistance
    ){
        if((row < 0 || row >= grid.length) || (col < 0 || col >= grid[0].length)){
            return;
        }
        if(grid[row][col] == -1 || grid[row][col] == 0){
            return;
        }
        if(grid[row][col] <= currDistance){
            return;
        }
        grid[row][col] = currDistance;
        updateGrid(grid,row,col+1,currDistance+1);
        updateGrid(grid,row,col-1,currDistance+1);
        updateGrid(grid,row+1,col,currDistance+1);
        updateGrid(grid,row-1,col,currDistance+1);
    }
    
}
