class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            Set<Character> rowFreq=new HashSet<>();
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    continue;
                }
                else if(rowFreq.contains(board[i][j])){
                    return false;
                }else{
                    rowFreq.add(board[i][j]);
                }

            }
        }

        for(int i=0;i<9;i++){
            Set<Character> columnFreq=new HashSet<>();
            for (int j=0;j<9;j++){
                if(board[j][i]=='.'){
                    continue;
                }
                else if(columnFreq.contains(board[j][i])){
                    return false;
                }else{
                    columnFreq.add(board[j][i]);
                }
            }
        }

        for( int squre=0;squre<9;squre++){
            Set<Character> cellFreq=new HashSet<>();
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    int row=(squre/3)*3+i;
                    int col=(squre%3)*3+j;
                    if (board[row][col] == '.') continue;
                    if (cellFreq.contains(board[row][col])) return false;
                    cellFreq.add(board[row][col]);
                }
            }
        }
        return true;

    }
}
