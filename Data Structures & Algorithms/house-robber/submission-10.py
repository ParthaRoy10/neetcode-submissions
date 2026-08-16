class Solution:
    def rob(self, nums: List[int]) -> int:
        dp = [-1] * len(nums)
        
        return max(self.findMax(nums,0,dp),self.findMax(nums,1,dp))

    def findMax(self,nums,index,dp):
        if index >= len(dp):
            return 0
        if dp[index] is not -1 :
            return dp[index]
        dp[index] = max(nums[index] + self.findMax(nums,index + 2,dp),self.findMax(nums,index + 1,dp))
        return dp[index]
 