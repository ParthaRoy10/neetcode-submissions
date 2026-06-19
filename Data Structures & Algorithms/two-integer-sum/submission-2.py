class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        mapp = {}

        for i,num in enumerate(nums):
            req = target - num

            if req in mapp:
                return [mapp[req],i]
            mapp[num] = i      
