class Solution {
    public boolean isPalindrome(String s) {
        int startInd=0;
        int endInd=s.length()-1;
        
        while(startInd<endInd){
            while(startInd < endInd && !Character.isLetterOrDigit(s.charAt(startInd))){
                startInd++;
            }
            while(startInd < endInd && !Character.isLetterOrDigit(s.charAt(endInd))){
                endInd--;
            }
            if(Character.toLowerCase(s.charAt(startInd))!=Character.toLowerCase(s.charAt(endInd))){
                return false;
            }
            startInd++;
            endInd--;
        }
        return true;
    }
}
