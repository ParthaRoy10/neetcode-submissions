class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(
            intervals,
            (a,b) -> Integer.compare(a[0],b[0])
        );

        int[][] idxmap = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            idxmap[i][0] = i;
            idxmap[i][1] = queries[i]; 
        }
        Arrays.sort(
            idxmap,
            (a,b) -> Integer.compare(a[1],b[1])
        );

        int[] ans = new int[queries.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );

        int count=0;
        for(int i=0;i<queries.length;i++){
            int qidx = idxmap[i][0];
            int qend = idxmap[i][1];

            
            while(count < intervals.length && intervals[count][0] <= qend){
                pq.offer(new int[]{intervals[count][1]-intervals[count][0]+1,intervals[count][1]});
                count++;
            }
            int len = -1 ;
            while(!pq.isEmpty() && pq.peek()[1] < qend){
                pq.poll();
            }
            if(!pq.isEmpty()){
                len = pq.peek()[0];
            }
            ans[qidx] = len;
        }
        return ans;
    }
}
