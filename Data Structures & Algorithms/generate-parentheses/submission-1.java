class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        backtrack(n,res,new StringBuilder(),0,0);
        return res;
    }

    private void backtrack(int n,List<String> res,StringBuilder curr,int op,int cl){
        if(curr.length()==2*n){
            res.add(curr.toString());
            return;
        }

        if(op < n){
            curr.append("(");
            backtrack(n,res,curr,op+1,cl);
            curr.deleteCharAt(curr.length()-1);
        }
        if(op > cl){
            curr.append(")");
            backtrack(n,res,curr,op,cl+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
