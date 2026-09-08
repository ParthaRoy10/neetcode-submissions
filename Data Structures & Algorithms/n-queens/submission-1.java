class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];
        for(int i=0;i <n;i++){
            Arrays.fill(board[i],'.');
        }

        boolean[] cols = new boolean[n];
        boolean[] dig1 = new boolean[2*n - 1];
        boolean[] dig2 = new boolean[2*n - 1];

        findSol(0,board,ans,cols,dig1,dig2);
        return ans;
    }

    private void findSol(
        int row,
        char[][] board,
        List<List<String>> ans,
        boolean[] col,
        boolean[] dig1,
        boolean[] dig2
    ){
        if(row == board.length){
            List<String> temp = new ArrayList<>();

            for(char[] r:board){
                temp.add(new String(r));
            }
            ans.add(temp);
            return;
        }

        int n = board.length;
        for(int i=0;i<n;i++){
            
            int d1 = row - i +n -1;
            int d2 = row+i;

            if (col[i] || dig1[d1] || dig2[d2])
                continue;

            board[row][i] = 'Q';
            col[i] = true;
            dig1[d1] = true;
            dig2[d2] = true;

            findSol(row + 1, board, ans,col, dig1, dig2);

            board[row][i] = '.';
            col[i] = false;
            dig1[d1] = false;
            dig2[d2] = false;
        }
    }
}
