class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<>(
            (a,b) -> b-a
        );

        for(int stone : stones){
            que.offer(stone);
        }

        while(que.size() > 1){
            int num1 = que.poll();
            int num2 = que.poll();

            if(num1 != num2){
                que.offer(num1-num2);
            }
        }
        if(que.isEmpty()){
                return 0;
            }
        return que.poll();
    }   
}
