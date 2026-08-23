class Solution {

    // Optimized solution is in leetcode From DFS to BFS

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> que = new LinkedList<>();


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 0){
                    que.offer(new int[]{i,j});
                }
            }
        }

        int[][] directions = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        while(!que.isEmpty()){
            int[] curr = que.poll();

            int row = curr[0];
            int col = curr[1];
            for(int[] dir: directions){
                int newRow = row + dir[0];
                int newCol = curr[1] + dir[1];

                if((newRow < 0 || newRow >= rows) || (newCol <0 || newCol >= cols)){
                    continue;
                }

                if (grid[newRow][newCol] == -1) {
                    continue;
                }

                if (grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[newRow][newCol] = grid[row][col] + 1;
                que.offer(new int[]{newRow,newCol});
            }
        }

    }

    
}
