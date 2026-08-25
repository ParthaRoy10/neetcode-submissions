class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 1){
                    int currArea = visitIland(grid,i,j,rows,cols);
                    maxArea = Math.max(maxArea,currArea);
                }
            }
        }
        return maxArea;
    }
    private int visitIland(int[][] grid,int row,int col,int rowSize,int colSize){
        if((row<0 || row >= rowSize) || (col < 0 || col >=colSize)){
            return 0;
        }
        if(grid[row][col] == 0){
            return 0;
        }
        int area=1;
        grid[row][col] = 0;

        area += visitIland(grid,row,col+1,rowSize,colSize);
        area += visitIland(grid,row,col-1,rowSize,colSize);
        area += visitIland(grid,row+1,col,rowSize,colSize);
        area += visitIland(grid,row-1,col,rowSize,colSize);
        return area;
    }
}
