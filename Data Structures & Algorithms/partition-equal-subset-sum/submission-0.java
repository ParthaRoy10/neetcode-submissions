class Solution {
    public boolean canPartition(int[] nums) {
        int set1 =0;
        int set2 = 0;
        for(int i=0;i<nums.length;i++){
            set2 += nums[i]; 
        }

        boolean ans = dfs(nums,set1,set2,0);
        return ans;
    }

    private boolean dfs(int[] nums,int set1,int set2,int idx){
        if(set1 == set2 ){
            return true;
        }

        if(idx >=nums.length){
            return false;
        }

        if(dfs(nums,set1+nums[idx],set2-nums[idx],idx+1)){
            return true;
        }
        if(dfs(nums,set1,set2,idx+1)){
            return true;
        }
        return false;
    }
}
