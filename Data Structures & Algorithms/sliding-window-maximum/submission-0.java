class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<Integer>();
        int i =0;
        int[] res = new int[nums.length-k+1];
        for(int r=0;r<nums.length;r++){

            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[r]){
                dq.pollLast();
            }
            dq.offer(r);

            while(dq.peekFirst()<= r-k){
                dq.pollFirst();
            }

            if(r+1-k>=0){
                res[i] = nums[dq.peekFirst()];
                i++;
            }

        }

        return res;
    }
}
