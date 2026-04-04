class Solution {
    public int minDistance(String word1, String word2) {
        return recurse(word1, word2, 0,0, 0);
    }
    
    public int recurse(String w1, String w2, int i, int j, int dis){
        if(j == w2.length()){
            return dis + (w1.length()-i);
        }
        if(i==w1.length()){
            return dis + (w2.length()-j);
        }
        
        if(w1.charAt(i)==w2.charAt(j)){
            return recurse(w1, w2, i+1, j+1, dis);
        } else {
            //insert
            int a = recurse(w1, w2, i, j+1, dis+1);
            
            //delete
            int b = recurse(w1, w2, i+1, j, dis+1);
            
            //replace
            int c = recurse(w1, w2, i+1, j+1, dis+1);
            
            return Math.min(Math.min(a,b), c);
        }
    }
}
