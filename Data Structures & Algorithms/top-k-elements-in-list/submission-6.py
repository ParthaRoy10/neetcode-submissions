class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        cnt = Counter(nums)

        res_dict=cnt.most_common(k)

        res=[]

        for key,value in res_dict:
            res.append(key)

        return res