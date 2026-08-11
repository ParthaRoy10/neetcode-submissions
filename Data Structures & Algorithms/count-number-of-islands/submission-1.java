class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int iland = 0;

        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j] == false){
                    if(grid[i][j]=='1'){
                        iland +=1;
                        findLand(grid,visited,i,j,rows,cols);
                    }else{
                        visited[i][j] = true;
                    }
                }
            }
        }
        return iland;
    }
    private void findLand(char[][] grid,boolean[][] visited,int row,int col,int rowSize, int colSize){
        if(row >= rowSize || row < 0){
            return;
        }
        if(col >= colSize || col < 0){
            return;
        }
        if(visited[row][col] == true){
            return;
        }
        visited[row][col] = true;
        if(grid[row][col] == '1'){
            findLand(grid,visited,row,col+1,rowSize,colSize);
            findLand(grid,visited,row,col-1,rowSize,colSize);
            findLand(grid,visited,row+1,col,rowSize,colSize);
            findLand(grid,visited,row-1,col,rowSize,colSize);
        }
    }
}
