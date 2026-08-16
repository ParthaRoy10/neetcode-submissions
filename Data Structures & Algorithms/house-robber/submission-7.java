class Solution {
    public int rob(int[] nums) {
        // Solving the problem with the memoization. 
        // Backtracking Solution is shared in leet code.
        // Reccurance solution is in python. 

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int[] dp = new int[n];
        if(dp.length < 2){return nums[0];}
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }
}
