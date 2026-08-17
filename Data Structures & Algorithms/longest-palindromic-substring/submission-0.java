class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen = 0;
        int resStart = 0;

        for(int i=0;i<n;i++){

            int l = i;
            int r = i;
            int curr = 0;

            while(l>=0 && r < n && (s.charAt(l) == s.charAt(r))){
                l--;
                r++;
            }

            curr = r-l-1;
            if(curr > maxLen){
                resStart = l+1;
                maxLen = curr;
            }
        }

        for(int i=0;i<n;i++){
            int l = i;
            int r = i+1;
            int curr = 0;
            while(l>=0 && r < n && (s.charAt(l) == s.charAt(r))){
                l--;
                r++;
            }
            curr = r-l-1;
            if(curr > maxLen){
                resStart =l+1;
                maxLen = curr;
            }
        }
        return s.substring(resStart,resStart+maxLen);
    }
}
