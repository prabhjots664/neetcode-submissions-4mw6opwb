class Solution {
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return uniquePathsDp(m,n,dp);

    }

    
    int uniquePathsDp(int m, int n, int[][] dp){
        if(m<1 || n<1) return 0;
        if(m==1 && n==1) return 1;
        if(m==2 && n==1) return 1;
        if(m==1 && n==2) return 1;
        
        if(dp[m][n]!=-1) return dp[m][n];

        dp[m][n] = uniquePaths(m-1, n) + uniquePaths(m, n-1);
        return dp[m][n];
    }
}
