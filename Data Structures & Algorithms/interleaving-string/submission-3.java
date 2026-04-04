class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        return isInterleaveRecurse(s1, s2, s3, 0, 0, 0, dp);
    }

    private boolean isInterleaveRecurse(String s1, String s2, String s3, int i, int j, int k, int[][][] dp) {
        if(i==s1.length() && j == s2.length() && k == s3.length()){
            return true;
        }

        if(dp[i][j][k]!=0){
            return dp[i][j][k]==1;
        }

        boolean a = false, b = false;
        if( k<s3.length() && i<s1.length() && s3.charAt(k) == s1.charAt(i)){
            a = isInterleaveRecurse(s1, s2, s3, i+1, j, k+1, dp);
        }

        if(k<s3.length() && j<s2.length() && s3.charAt(k) == s2.charAt(j)){
            b = isInterleaveRecurse(s1, s2, s3, i, j+1, k+1, dp);
        }

        dp[i][j][k] = a || b ? 1 : 2;
        
        return a || b;

    }
}
