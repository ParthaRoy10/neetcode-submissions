class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int maxFrequency = 0;
        int length = 0;

    
        int[] count= new int[26];

        for (int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            count[ch-'A']++;

            maxFrequency = Math.max(maxFrequency,count[ch-'A']);
            while((i-l+1)-maxFrequency > k){
                count[s.charAt(l) - 'A']--;
                l++;
            }
            length = Math.max(length, i - l + 1);
        }


        return length;
    }
}
