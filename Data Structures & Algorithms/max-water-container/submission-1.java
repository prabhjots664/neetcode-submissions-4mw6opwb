class Solution {
    public int maxArea(int[] h) {
        int i = 0, j = h.length-1;
        int max = 0;
        while(i<j){
            int water = Math.min(h[i],h[j]) * (j-i);
            max = Math.max(max,water);
            if(h[i]>h[j]){
                j--;
            } else {
                i++;
            }
        }

        return max;
    }
}
