class Solution {
    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Deque<int[]> que = new ArrayDeque<>();

        int fresh = 0;

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if(grid[i][j] == 2){
                    que.offer(new int[]{i, j});
                }

                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        int minutes = 0;

        while(!que.isEmpty() && fresh > 0){

            int size = que.size();

            for(int i = 0; i < size; i++){

                int[] curr = que.poll();

                for(int[] dir : directions){

                    int row = curr[0] + dir[0];
                    int col = curr[1] + dir[1];

                    if(row < 0 || row >= rows ||
                       col < 0 || col >= cols){
                        continue;
                    }

                    if(grid[row][col] != 1){
                        continue;
                    }

                    grid[row][col] = 2;
                    fresh--;

                    que.offer(new int[]{row, col});
                }
            }

            minutes++;
        }
        if(fresh > 0){
            return -1;
        }

        return minutes;
    }
}