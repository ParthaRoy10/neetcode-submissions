class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return (
            Math.min(
                findMinCost(cost,0,dp),findMinCost(cost,1,dp)
            )
        );
    }

    private int findMinCost(int[] cost,int index,int[] dp){
        if(index < 0 || index >= cost.length){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        dp[index] = cost[index] + Math.min(
            findMinCost(cost,index+1,dp),findMinCost(cost,index+2,dp)
        );
        return dp[index];
    }
}
