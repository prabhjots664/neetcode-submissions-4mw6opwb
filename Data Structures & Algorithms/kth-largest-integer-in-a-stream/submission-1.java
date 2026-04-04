class KthLargest {

    int maxSize;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.maxSize = k;
        this.pq = new PriorityQueue<>();

        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        
        while (pq.size()>maxSize){
            pq.poll();
        }
    }

    public int add(int val) {

        if(pq.size()<maxSize){
            pq.offer(val);
        } else if(!pq.isEmpty() && pq.size()==maxSize && pq.peek()<val){
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}