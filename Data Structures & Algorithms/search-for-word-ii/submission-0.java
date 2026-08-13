class Solution {
    class Tries{
        Tries[] trie;
        String word ;
        Tries(){
            trie = new Tries[26];
            word = null;
        }
    }
    private Tries root = new Tries();

    public List<String> findWords(char[][] board, String[] words) {
        for(String str: words){
            insert(str,root);
        }

        int rows= board.length;
        int cols = board[0].length;
        List<String> ans = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                searchWords(board,ans,i,j,rows,cols,root);
            }
        }
        return ans;
    }

    private void insert(String str, Tries root){
        Tries node = root;
        for(char ch: str.toCharArray()){
            int index = ch -'a';
            if(node.trie[index] == null){
                node.trie[index] = new Tries();
            }
            node = node.trie[index];
        }
        node.word = str;
    }

    private void searchWords(char[][] board,List<String> ans,int row,int col,int rows,int cols,Tries root){
        if(row < 0 || row >= rows){
            return;
        }
        if(col <0 || col >= cols){
            return;
        }
        char ch = board[row][col];

        if(ch == '#'){
            return;
        }

        int index = ch -'a';

        
        Tries next = root.trie[index];
        if(next == null){
            return;
        }
        board[row][col] = '#';

        if(next.word != null){
            ans.add(next.word);
            next.word = null;
        }
        
        searchWords(board,ans,row,col+1,rows,cols,next);
        searchWords(board,ans,row,col-1,rows,cols,next);
        searchWords(board,ans,row+1,col,rows,cols,next);
        searchWords(board,ans,row-1,col,rows,cols,next);
        board[row][col] = ch;
        return;
    }
}
