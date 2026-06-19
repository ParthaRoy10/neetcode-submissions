class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int en = s.length()-1;
        s=s.toLowerCase();


        while(st<en){
            while(st<en && !Character.isLetterOrDigit(s.charAt(st))){
                st++;
            }
            while(st<en && !Character.isLetterOrDigit(s.charAt(en))){
                en--;
            }
            if(st<en && s.charAt(st) != s.charAt(en)){
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
