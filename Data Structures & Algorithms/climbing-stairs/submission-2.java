class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        if(n < 2 ){
            return 1;
        }
        Arrays.fill(dp,-1);
        findWays(dp,n);
        return dp[n];
    }

    private int findWays(int[] dp,int curr){
        if(curr == 0 || curr == 1){
            return 1;
        }
        if(dp[curr] != -1){
            return dp[curr];
        }
        dp[curr] = findWays(dp,curr-1) + findWays(dp,curr-2);
        return dp[curr];
    }
}
