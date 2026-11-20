class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }

        int l = 0;
        int r = s.length()-1;

        while(l<r){
            char lc = s.charAt(l);
            char rc = s.charAt(r);

            while(l<r && !Character.isLetterOrDigit(lc)){
                l++;
                lc = s.charAt(l);
            }

            while(l<r && !Character.isLetterOrDigit(rc)){
                r--;
                rc=s.charAt(r);
            }
            if(Character.toLowerCase(lc) != Character.toLowerCase(rc)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
