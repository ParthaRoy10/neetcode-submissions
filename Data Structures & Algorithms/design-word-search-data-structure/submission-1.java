class WordDictionary {

    class TriNode{
        TriNode[] cld;
        boolean isEnd;

        TriNode(){
            cld = new TriNode[26];
            isEnd = false;
        }
    }
    private TriNode root;

    public WordDictionary() {
        root = new TriNode();
    }

    public void addWord(String word) {
        TriNode curr = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(curr.cld[idx] == null){
                curr.cld[idx] = new TriNode();
            }
            curr = curr.cld[idx];
        }
        curr.isEnd = true ;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int idx, TriNode node){

        if(node ==null) {return false;}
        if(word.length() == idx){return node.isEnd;}

        char ch = word.charAt(idx);

        if(ch == '.' ){
            for(TriNode child : node.cld){
                if(child != null && dfs(word,idx+1,child)){
                    return true;
                }
            }
            return false;
        }
        return dfs(word,idx+1,node.cld[ch - 'a']);
    }
}
