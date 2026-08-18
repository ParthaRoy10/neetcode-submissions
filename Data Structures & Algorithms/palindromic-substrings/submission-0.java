class Solution {
    public int countSubstrings(String s) {
        
        int res = 0;

        for(int i=0;i<s.length();i++){

            int prev = i;
            int next = i;

            while((prev > -1 && next < s.length()) && (s.charAt(prev) == s.charAt(next))){
                res++;
                prev--;
                next++;
            }
        }

        for(int i=0;i<s.length();i++){
            int prev = i;
            int next = i+1;

            while((prev > -1 && next < s.length()) && (s.charAt(prev) == s.charAt(next))){
                res++;
                prev--;
                next++;
            }
        }
        return res;
    }
}
