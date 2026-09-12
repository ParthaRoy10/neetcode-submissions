class Solution {

    public int jump(int[] nums) {
        int jmp = 0;
        int furthest = 0;
        int currEnd = 0;
        int n= nums.length;

        for(int i=0;i<n;i++){
            
            if(i==n-1){return jmp;}
            furthest = Math.max(furthest,nums[i]+i);
            if(i==currEnd){
                jmp++;
                currEnd = furthest;
            }
        }
        return jmp;
    }
}