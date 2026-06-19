class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashMap<Character,Integer> mapp = new HashMap();

        for(char ch : s.toCharArray()){
            if(mapp.containsKey(ch)){
                left = Math.max(left,mapp.get(ch)+1);
            }
            mapp.put(ch,right);
            int currMax = right -left +1;
            
            max = Math.max(max,currMax);
            right++;
        }
        return max;
    }
}
