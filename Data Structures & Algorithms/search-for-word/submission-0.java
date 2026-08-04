class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0; i< row;i++){
            for(int j=0; j<col;j++){
                if(findStr(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findStr(char[][] board,String word,int row,int col,int index){
        if(word.length() == index){
            return true;
        }
        if((row < 0 || row >= board.length) || (col < 0 || col >= board[0].length) || (board[row][col] != word.charAt(index))){
            return false;
        }

        

        if(word.charAt(index) == board[row][col]){
            char curr = board[row][col];
            board[row][col] = '#';

            if(
                findStr(board,word,row,col+1,index+1) ||
                findStr(board,word,row-1,col,index+1) ||
                findStr(board,word,row,col-1,index+1) ||
                findStr(board,word,row+1,col,index+1)
            ){
                return true;
            }
            board[row][col] = curr;
        }
        return false;
    }
}
