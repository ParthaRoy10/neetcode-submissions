class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        int maxLen = 0;

        for(String str:wordDict){
            maxLen = Math.max(maxLen,str.length());
        }

        boolean[] canConstruct = new boolean[s.length()+1];
        canConstruct[0] = true;

        for(int i=1;i< canConstruct.length;i++){

            for(int j=i-1;j>=Math.max(0,(i-maxLen));j--){
                if(canConstruct[j] && set.contains(s.substring(j,i))){
                    canConstruct[i] = canConstruct[j];
                    break;
                }
            }
        }
        return canConstruct[s.length()];
    }
}
