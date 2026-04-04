class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a,b)->Integer.compare(b, a));
        for (int i = 0; i < freq.length; i++) {
            if(freq[i]>0){
                maxpq.add(freq[i]);
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        while(!maxpq.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty() && q.peek()[1]==time){
                maxpq.add(q.poll()[0]);
            }
            time++;
            if(!maxpq.isEmpty()){
                int highestFreq = maxpq.poll();
                highestFreq--;
                if(highestFreq>0){
                    int[] nextOccurence = {highestFreq, time+n};
                    q.offer(nextOccurence);
                }
            }
            
        }
        
        return time;
    }
}
