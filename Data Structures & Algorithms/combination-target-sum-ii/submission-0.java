class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findCombinations(candidates,target,0,new ArrayList<>());
        return ans;
    }


    private List<List<Integer>> ans = new ArrayList<>();
    private void findCombinations(int[] candidates,int need,int st,List<Integer> curr){
        if(need == 0){
            ans.add(new ArrayList(curr));
            return;
        }
        for(int i=st;i<candidates.length;i++){

            if(i > st && candidates[i-1] == candidates[i] ){
                continue;
            }

            if(need < candidates[i]){
                break;
            }

            curr.add(candidates[i]);
            findCombinations(candidates,need-candidates[i],i+1,curr);
            curr.remove(curr.size() - 1);
        }
    }
}
