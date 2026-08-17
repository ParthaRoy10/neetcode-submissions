class Solution {
    public int rob(int[] nums) {
        // consider 1st House
        int n = nums.length;
        if(n==1){return nums[0];}
        int case1 = findBest(nums,0,n-2);
        int case2 = findBest(nums,1,n-1);
        return Math.max(case1,case2);
    }

    private int findBest(int[] nums,int index,int end){

        int prevMax = 0;
        int currMax = nums[index];

        for(int i = index+1;i<=end;i++){
            int temp = currMax;
            currMax = Math.max(prevMax+nums[i],currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
