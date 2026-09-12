class Solution {
    public boolean canJump(int[] nums) {
        int jmp = 1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(i==n-1){
                return true;
            }
            jmp -= 1;
            jmp = Math.max(jmp,nums[i]);
            if(jmp == 0){
                return false;
            }
        }
        return true;
    }
}
