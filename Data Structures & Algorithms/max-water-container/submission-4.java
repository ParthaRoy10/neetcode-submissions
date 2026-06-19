class Solution {
    public int maxArea(int[] heights) {
        int len=heights.length;
        int start=0;
        int end=len-1;
        int maxWater=-1;

        while(start<end){
            int distance=end-start;
            int currMax=(heights[start]<heights[end])?heights[start]:heights[end];
            int currWater=currMax*distance;
            maxWater=Math.max(maxWater,currWater);
            
            if(heights[start]<heights[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxWater;
    }
}
