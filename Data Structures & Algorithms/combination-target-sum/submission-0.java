class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> curr=new ArrayList<>();
        return findSum(0,target,nums,curr);
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<List<Integer>> findSum(int st,int need,int[] nums,List<Integer> curr){
        if(need == 0){
            res.add(new ArrayList(curr));
            return res;
        }
        if(need < 0){
            return res;
        }
        for(int i= st;i<nums.length;i++){
            curr.add(nums[i]);
            findSum(i,need-nums[i],nums,curr);
            curr.remove(curr.size()-1);

        }
        return res;
    }
}
