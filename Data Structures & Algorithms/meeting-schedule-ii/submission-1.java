/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)->a.start-b.start);

        int maxSize = 0;
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((a,b)->a.end-b.end);
        for (Interval interval: intervals){
            while(!pq.isEmpty() && pq.peek().end <= interval.start){
                pq.poll();
            }
            pq.offer(interval);
            if(maxSize<pq.size()){
                maxSize = pq.size();
            }
        }

        return maxSize;
    }
}
