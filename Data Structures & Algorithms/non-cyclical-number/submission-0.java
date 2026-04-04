class Solution {
   public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = squareSumDigits(n);
        }

        return true;
    }

    private int squareSumDigits(int n) {
        
        int sum = 0;
        while (n>0){
            int digit = n % 10;
            n = n/10;
            sum += digit*digit;
        }
        return sum;
    }
}
