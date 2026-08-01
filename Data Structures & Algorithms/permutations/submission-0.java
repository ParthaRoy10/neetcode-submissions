class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited=new boolean[nums.length];
        findCombinations(nums,visited,ans,new ArrayList<>());
        return ans;
    }

    private void findCombinations(int[] nums,
                                boolean[] visited,
                                List<List<Integer>> ans,
                                List<Integer> curr){
        
        if(curr.size()==nums.length){
            ans.add(new ArrayList(curr));
            return;
            }
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            curr.add(nums[i]);
            visited[i]=true;
            findCombinations(nums,visited,ans,curr);

            curr.remove(curr.size()-1);
            visited[i]=false;
        }
    }
}
