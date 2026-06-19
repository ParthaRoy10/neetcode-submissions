class Solution {
    public boolean isPalindrome(String s) {
        int st = 0;
        int en = s.length()-1;


        while(st<en){
            if(!Character.isLetterOrDigit(s.charAt(st))){
                st++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(en))){
                en--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(st)) != Character.toLowerCase(s.charAt(en))){
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}
