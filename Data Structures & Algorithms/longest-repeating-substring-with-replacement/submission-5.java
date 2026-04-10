class Solution {
    public int characterReplacement(String s, int k) {
        int maxfreq= 0, l=0, res=0;;
        int[] freq = new int[26];

        for(int r=0;r<s.length();r++){

            freq[s.charAt(r)-'A']++;
            maxfreq = Math.max(maxfreq, freq[s.charAt(r)-'A']);

            while(r-l+1 - maxfreq > k && l<=r){
                freq[s.charAt(l)-'A']--;
                l++;
            }

            res = Math.max(r-l+1, res);
        }

        return res;
    }
}
