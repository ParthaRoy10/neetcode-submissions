class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){return 0;}
        Map<Integer,Integer> mapp = new HashMap<>();
        int max = 1;
        for(int i=0;i<nums.length;i++){
            if(mapp.containsKey(nums[i])){
                continue;
            }
            mapp.put(nums[i],1);
            if(mapp.containsKey(nums[i]-1)){
                mapp.put(nums[i],mapp.get(nums[i]-1)+1);
                max=Math.max(max,mapp.get(nums[i]));
            }
            int curr = nums[i];
            while(mapp.containsKey(curr+1)){
                mapp.put(curr+1,mapp.get(curr)+1);
                max = Math.max(max,mapp.get(curr+1));
                curr++;
            }
        }
        return max;
    }
}
