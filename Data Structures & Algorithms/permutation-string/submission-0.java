class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int l = 0;

        int[] ft = new int[26];
        int[] wt = new int[26];

        for(int i=0;i<s1.length();i++){
            ft[s1.charAt(i)-'a']++;
            wt[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(ft,wt)){
            return true;
        }
        for(int r=s1.length();r<s2.length();r++){
            wt[s2.charAt(l)-'a']--;
            l++;
            wt[s2.charAt(r)-'a']++;
            if(Arrays.equals(wt,ft)){
                return true;
            }
        }
        return false;
    }
}
