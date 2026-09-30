class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] gr = new ArrayList[n+1];
        int[] vi = new int[n+1];
        Arrays.fill(vi,Integer.MAX_VALUE);
        vi[k]=0;

        for(int i=0;i<n+1;i++){
            gr[i]=new ArrayList<>();
        }
        
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            gr[u].add(new int[]{v,w});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );

        pq.offer(new int[]{k,0});
        int time = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currTime = curr[1];

            List<int[]> neis = gr[currNode];

            for(int[] nei:neis){
                int nn=nei[0];
                int nt=nei[1];

                if(currTime+nt < vi[nn]){
                    vi[nn] = currTime + nt;
                    pq.offer(new int[]{nn, vi[nn]});
                }
            }
        }

        int tt = 0;
        for(int i=1;i<n+1;i++){
            if(vi[i]==Integer.MAX_VALUE){
                return -1;
            }
            tt = Math.max(tt, vi[i]);
        }

        return tt;
    }
}
