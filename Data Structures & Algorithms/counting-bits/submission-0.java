class Solution {
    public int[] countBits(int m) {
        int[] res = new int[m+1];

        for(int i = 0; i<=m ; i++){
            int bits = 0;
            int n = i;

        while(n>0){
            bits += n%2;
            n /= 2;
        }

        res[i] = bits;
        }

        return res;
    }
}
