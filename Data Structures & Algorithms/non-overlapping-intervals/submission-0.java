class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));
        int[] prev = intervals[0];
        int res =0;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<prev[1]){
                res++;
                if(intervals[i][1]<prev[1]){
                    prev = intervals[i];
                }
            } else {
                prev = intervals[i];
            }
        }

        return res;
    }
}
