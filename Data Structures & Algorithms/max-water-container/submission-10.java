class Solution {
    public int maxArea(int[] heights) {
        int ans = Integer.MIN_VALUE;
        int n=heights.length;
        int l = 0;
        int r = n-1;

        while(l<r){

            int currWater = Math.min(heights[l],heights[r])*(r-l);
            ans = Math.max(ans,currWater);

            if(heights[l] > heights[r]){
                r--;
            }else{
                l++;
            }

        }
        return ans;
    }
}
