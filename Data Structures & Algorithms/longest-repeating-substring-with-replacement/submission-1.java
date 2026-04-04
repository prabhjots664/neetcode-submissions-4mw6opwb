class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int[] charCounts = new int[26];
        int maxLength = 0;
        int maxFreq = 0;
        for (int j = 0; j < s.length(); j++) {
            int idx = s.charAt(j)-'A';
            charCounts[idx]++;
            if(maxFreq < charCounts[idx]){
                maxFreq = charCounts[idx];
            }


            while(j-i+1 - maxFreq > k){
                charCounts[s.charAt(i)-'A']--;
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
        }

        return maxLength;
    }
}
