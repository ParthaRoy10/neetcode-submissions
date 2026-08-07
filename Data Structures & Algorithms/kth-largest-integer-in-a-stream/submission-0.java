class KthLargest {
    private PriorityQueue<Integer> pq ;
    private int max;

    public KthLargest(int k, int[] nums) {
        this.max = k;
        this.pq = new PriorityQueue<>();
        for(int i=0;i<nums.length ; i++){
            pq.offer(nums[i]);
            if(pq.size() > max){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size() > max){
            pq.poll();
        }
        return pq.peek();
    }
}
