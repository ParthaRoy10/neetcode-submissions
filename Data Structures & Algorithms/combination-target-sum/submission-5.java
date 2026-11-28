class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(nums[i]);
            findCombination(nums,ans,curr,i,target-nums[i]);
        }

        return ans;
    }

    private static void findCombination(
        int[] nums,
        List<List<Integer>> ans,
        List<Integer> curr,
        int idx,
        int req
    ){
        if(req == 0){
            ans.add(new ArrayList<>(curr)); 
            return;
        }

        if(req < nums[idx]){
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(req<nums[i]){
                break;
            }else{
                curr.add(nums[i]);
                findCombination(nums,ans,curr,i,req-nums[i]);
                curr.remove(curr.size() - 1);
            }
        }
        return;
    }
}
