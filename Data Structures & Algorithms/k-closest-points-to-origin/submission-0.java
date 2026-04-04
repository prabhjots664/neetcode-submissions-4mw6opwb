class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Double>> pq = new PriorityQueue<>((a,b)-> Double.compare(b.get(2),a.get(2)));
        for (int i = 0; i < points.length; i++) {
            Double distance = Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]);
            List<Double> list = Arrays.asList((double)points[i][0], (double)points[i][1], distance);
            pq.offer(list);

            while (pq.size()>k){
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()){
            List<Double> list = pq.poll();
            res[i][0] = (int)(double)list.get(0);
            res[i][1] = (int)(double)list.get(1);
            i++;
        }
        
        return res;
    }
}
