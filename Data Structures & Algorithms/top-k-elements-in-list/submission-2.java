class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }

        System.out.println(map.entrySet());

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>( (a,b)-> (a.getValue() - b.getValue()));

        for (Map.Entry entry: map.entrySet()){
            pq.offer(entry);
        }
        while(pq.size()>k){
            pq.poll();
        }

        System.out.println(pq);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }
}
