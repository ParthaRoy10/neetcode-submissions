class Solution {
    public int maxArea(int[] heights) {
        int st=0;
        int en=heights.length-1;
        int max=0;

        while(st<en){
            int currCap = Math.min(heights[st],heights[en])*(en-st);
            if(currCap > max){
                max=currCap;
            }
            if(heights[st]<heights[en]){
                st++;
            }else{
                en--;
            }
        }
        return max;
    }
}
