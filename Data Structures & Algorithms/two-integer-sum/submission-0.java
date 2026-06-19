class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mapp=new HashMap<>();

        for( int i=0;i<nums.length;i++){
            int curr=nums[i];
            int req=target-curr;
            if(mapp.containsKey(req)){
                return new int[]{mapp.get(req),i};
            }else{
                mapp.put(curr,i);
            }
        }
        return new int[]{0,0};
    }
}
