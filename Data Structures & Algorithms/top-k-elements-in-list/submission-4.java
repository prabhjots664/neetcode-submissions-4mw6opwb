class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map =  new HashMap<>();
        for(int num : nums){
            int freq = map.getOrDefault(num, 0);
            map.put(num,freq+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[1],b[1]));

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){

            pq.offer(new int[]{entry.getKey(), entry.getValue()});

            if(pq.size()>k){
              pq.poll();
            }
        }
        
        int[] res = new int[pq.size()];
        int i =0;
        while(!pq.isEmpty()){
            res[i]=pq.poll()[0];
            i++;
        }

        return res;
    }
}
