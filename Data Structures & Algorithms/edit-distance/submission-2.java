class Solution {
    
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[101][101];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        return recurse(word1, word2, 0, 0, dp);
    }
    
    public int recurse(String w1, String w2, int i, int j, int[][] dp){
        if(j == w2.length()){
            return dp[i][j] = (w1.length()-i);
        }
        if(i==w1.length()){
            return dp[i][j] = (w2.length()-j);
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if(w1.charAt(i)==w2.charAt(j)){
            return dp[i][j] = recurse(w1, w2, i+1, j+1, dp);
        } else {
            //insert
            int a = recurse(w1, w2, i, j+1, dp);
            
            //delete
            int b = recurse(w1, w2, i+1, j, dp);
            
            //replace
            int c = recurse(w1, w2, i+1, j+1, dp);
            
            return dp[i][j] = 1 + Math.min(Math.min(a,b), c);
        }
    }

}
