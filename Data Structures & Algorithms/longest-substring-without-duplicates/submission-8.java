class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        int l=0,r=0;
        int[] freq = new int[500];
        int overAllMax=0,len=1;
        while(l<=r && r<s.length()){
            freq[s.charAt(r)]++;
            while(freq[s.charAt(r)]>1 && l<=r){
                freq[s.charAt(l)]--;
                l++;
            }
            
            len = r-l+1;
            overAllMax = Math.max(len,overAllMax);
            
            r++;
        }
        
        return overAllMax;
    }
}
