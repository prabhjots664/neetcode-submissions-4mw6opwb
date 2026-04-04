class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int indexOfZero = -1;
        boolean containsMoreThanOneZeros = false;
        for (int i = 0; i< nums.length; i++){
            if (nums[i]!=0){
                product *= nums[i];
            } else {
                if (indexOfZero!=-1){
                    containsMoreThanOneZeros = true;
                    break;
                }
                indexOfZero = i;
            }
        }
        int[] res = new int[nums.length];
        if(containsMoreThanOneZeros){
            return res;
        }
        if(indexOfZero!=-1){
            res[indexOfZero] = product;
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = product/nums[i];
        }

        return res;
    }
}  
