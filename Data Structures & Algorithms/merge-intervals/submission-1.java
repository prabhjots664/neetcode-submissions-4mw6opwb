class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> resList = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));

        resList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] prevInterval = resList.get(resList.size()-1);
            //there is an overlap if s of this is <= prev e. 
            if(interval[0]<=prevInterval[1]){
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            } else {
                resList.add(interval);
            }
        }
        
        int[][] res = new int[resList.size()][2];
        for (int i = 0; i < resList.size(); i++) {
            res[i][0] = resList.get(i)[0];
            res[i][1] = resList.get(i)[1];
        }
        
        return res;
    }
}
