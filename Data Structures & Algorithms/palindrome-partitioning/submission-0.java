class Solution {
    List<List<String>> ans = new ArrayList<>();
    List<String> curr = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(s,0);
        return ans;
    }


    private void dfs(String s,int st){
        if(st == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int end = st;end<s.length();end++){
            if(isPalindrome(s,st,end)){
                curr.add(s.substring(st,end+1));
                dfs(s,end+1);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String str,int st,int end){
        while(st < end){
            if(str.charAt(st) != str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;
    }
}
