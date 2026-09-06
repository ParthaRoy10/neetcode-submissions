class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        Deque<int[]> stack = new ArrayDeque<>();

        for(int i=0;i<cols;i++){
            if(board[0][i] == 'O'){
                board[0][i]='T';
                stack.push(new int[]{0,i});
            }
            if(board[rows-1][i] == 'O'){
                board[rows-1][i] = 'T';
                stack.push(new int[]{rows-1,i});
            }
        }

        for(int i=1;i<rows-1;i++){
            if(board[i][0] == 'O'){
                board[i][0] = 'T';
                stack.push(new int[]{i,0});
            }
            if(board[i][cols-1] == 'O'){
                board[i][cols-1] = 'T';
                stack.push(new int[]{i,cols-1});
            }
        }
        int[][] directions ={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };

        while(!stack.isEmpty()){
            int[] curr = stack.poll();
            for(int[] dir : directions){
                int row = curr[0]+dir[0];
                int col = curr[1]+dir[1];

                if((row < 0 || row >= rows) || (col <0 || col >= cols)){
                    continue;
                }
                if(board[row][col] != 'O'){
                    continue;
                }
                board[row][col] = 'T';
                stack.push(new int[]{row,col});
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }
}
