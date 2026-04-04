class Solution {
    public int hammingWeight(int n) {

        int bits = 0;

        while(n>0){
            bits += n%2;
            n /= 2;
        }

        return bits;
        
    }
}
