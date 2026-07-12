class PrefixTree {
    
    class TriNode{
        TriNode[] children;
        boolean isComplete;

        TriNode(){
            children = new TriNode[26];
            isComplete = false;
        }
    }
    private TriNode root;

    public PrefixTree() {
        root = new TriNode();   
    }

    public void insert(String word) {
        TriNode curr = root;

        for (char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null){
                curr.children[idx] = new TriNode();
            }
            curr = curr.children[idx];
        }
        curr.isComplete = true;
    }

    public boolean search(String word) {
        TriNode curr = root;

        for(char ch:word.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.isComplete;
    }

    public boolean startsWith(String prefix) {
        TriNode curr = root;

        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }
}
