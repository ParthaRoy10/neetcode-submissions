class Solution {
    public int leastInterval(char[] tasks, int n) {
        int time=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b[0],a[0])
        );
        Queue<int[]> que = new ArrayDeque<>();
        Map<Character,Integer> mapp = new HashMap<>();

        for(char ch:tasks){
            mapp.put(ch,mapp.getOrDefault(ch,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : mapp.entrySet()){
            int[] curr = new int[2];
            curr[0] = entry.getValue();
            curr[1] = 0;
            pq.offer(curr);
        }

        while(!pq.isEmpty() || !que.isEmpty()){

            if (pq.isEmpty() && !que.isEmpty()) {
                    time = que.peek()[1];
                }

            if(!que.isEmpty()){
                int[] temp = que.peek();
                if(temp[1] <= time){
                    pq.offer(que.poll());
                }
            }
            
            if(!pq.isEmpty()){
                int[] curr = pq.poll();
            
                curr[0] = curr[0] - 1;
                if(curr[0] > 0){
                    curr[1] = time + n + 1;
                    que.offer(curr);
                }
            }
            time += 1;
            
            
        }
        return time;
    }
}
