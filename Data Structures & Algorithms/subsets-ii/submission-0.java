class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        findSubset(nums,result,0,new ArrayList<>());
        return result;
    }

    private void findSubset(int[] nums,List<List<Integer>> res,int st,List<Integer> subset){
        res.add(new ArrayList(subset));

        for(int i=st;i<nums.length;i++){
            if(i > st && nums[i] == nums[i-1]){
                continue;
            }
            subset.add(nums[i]);
            findSubset(nums,res,i+1,subset);
            subset.remove(subset.size()-1);
        }
    }
}
