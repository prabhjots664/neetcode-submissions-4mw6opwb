class Solution {
    
    public int longestCommonSubsequence(String t1, String t2) {
        int[][] dp = new int[t1.length()+1][t2.length()+1];
        for (int i = 0; i < t1.length() + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return lcs(t1, t2, 0, 0, dp);
    }

    public int lcs(String text1, String text2, int i, int j, int[][] dp){

        if(i>=text1.length() || j>=text2.length()) return 0;

        String t1 = text1.substring(i), t2 = text2.substring(j);
        if(t1.isEmpty() || t2.isEmpty()) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];

        int longestLcs = 0;
        if(t1.charAt(0)==t2.charAt(0)){
            if(longestLcs<1+lcs(text1, text2, i+1, j+1, dp)){
                longestLcs = 1+lcs(text1, text2, i+1, j+1, dp);
            }
        } else {

            if(longestLcs<lcs(text1, text2, i+1, j, dp)){
                longestLcs = lcs(text1, text2, i+1, j, dp);
            }

            if(longestLcs<lcs(text1, text2, i, j+1, dp)){
                longestLcs = lcs(text1, text2, i, j+1, dp);
            }

        }

        dp[i][j] = longestLcs;
        return longestLcs;
    }

}
