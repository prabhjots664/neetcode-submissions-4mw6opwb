class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int[] charCounts = new int[26];
        int maxLength = 0;
        for (int j = 0; j < s.length(); j++) {
            charCounts[s.charAt(j)-'A']++;
            while(countTotalCharsMinusMax(charCounts)[0] > k){
                charCounts[s.charAt(i)-'A']--;
                i++;
            }
            int countK = countTotalCharsMinusMax(charCounts)[0];
            int totalLength = countTotalCharsMinusMax(charCounts)[1];
            if(totalLength > maxLength){
                maxLength = totalLength;
            }
        }

        return maxLength;
    }

    private int[] countTotalCharsMinusMax(int[] charCounts) {

        int maxCharCount = 0;
        int totalCount = 0;
        for (int i = 0; i < 26; i++) {
            totalCount += charCounts[i];
            if(maxCharCount<charCounts[i]){
                maxCharCount = charCounts[i];
            }
        }

        int[] res = new int[2];
        res[0] = totalCount-maxCharCount;
        res[1] = totalCount;
        return res;
    }
}
