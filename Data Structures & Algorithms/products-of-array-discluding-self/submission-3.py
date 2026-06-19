class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)

        pre = [1] * n
        suff = [1] * n
        res = [1] * n

        # Prefix products
        for i in range(1, n):
            pre[i] = nums[i - 1] * pre[i - 1]

        # Suffix products
        for i in range(n - 2, -1, -1):
            suff[i] = nums[i + 1] * suff[i + 1]

        # Final result
        for i in range(n):
            res[i] = pre[i] * suff[i]

        return res