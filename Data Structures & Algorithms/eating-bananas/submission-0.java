class Solution {

    int hrsNeeded(int[] piles, int r){
        int hrs = 0;
        for(int i =0;i<piles.length;i++){
            hrs += piles[i]/r + (piles[i]%r!=0 ? 1 : 0);
        }
        return hrs;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1, r = piles[piles.length-1];
        
        int res = Integer.MAX_VALUE;
        while(l<=r){
            int mid = l + (r-l)/2;
            int hrsNeeded = hrsNeeded(piles, mid);
            
            if(hrsNeeded <= h){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return res;
    }
}
