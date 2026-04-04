class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

       List<int[]> list = new ArrayList<>();
       int i =0, n= intervals.length;
       while(i<n && newInterval[0]>intervals[i][0]){
           list.add(intervals[i]);
           i++;
       }

       while(i<n && newInterval[1]>=intervals[i][1]){
           i++;
       }

       if(i<n && newInterval[1]>=intervals[i][0] && newInterval[1]<=intervals[i][1]){
           int max = Math.max(newInterval[1],intervals[i][1]);
           newInterval[1]=max;
           i++;
       }
       
       if(!list.isEmpty() && newInterval[0]<=list.get(list.size()-1)[1]){
           newInterval[0] = list.get(list.size()-1)[0];
           int max = Math.max(newInterval[1], list.get(list.size()-1)[1]);
           newInterval[1] = max;
           list.remove(list.size()-1);
       }
       
       list.add(newInterval);
       
       while (i<n){
           list.add(intervals[i]);
           i++;
       }

       return list.toArray(new int[list.size()][]);
    }
}
