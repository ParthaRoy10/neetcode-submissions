class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();

        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){

                if(Character.isLetter(s.charAt(i))){
                    str.append(Character.toLowerCase(s.charAt(i)));
                }
                else{
                    str.append(s.charAt(i));
                }
                
            }
        }

        String cr = str.toString();
        String rv = str.reverse().toString();

        if(cr.equals(rv)){
            return true;
        }
        else return false;
    }
}
