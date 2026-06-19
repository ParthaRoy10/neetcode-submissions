class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> st=new Stack<>();
        int maxArea=0;

        for(int i=0;i<heights.length;i++){
            int start=i;
            while(!st.isEmpty() && st.peek()[1]>heights[i]){
                int[] prev= st.pop();
                int currArea=prev[1]*(i-prev[0]);
                maxArea=Math.max(maxArea,currArea);
                start=prev[0];
            }
            st.push(new int[]{start,heights[i]});
        }
        while(!st.isEmpty()){
            int[] curr=st.pop();

            int currArea=curr[1]*(heights.length-curr[0]);
            maxArea=Math.max(maxArea,currArea);
        }

        return maxArea;
    }
}
