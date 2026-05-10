class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProds = new int[nums.length], postfixProds = new int[nums.length];

        int pre = 1;
        for(int i=0;i<nums.length;i++){
            prefixProds[i] = pre;
            pre *= nums[i];
        }

        int post = 1;
        for(int i =nums.length-1;i>=0; i--){
            postfixProds[i] = post;
            post *= nums[i];
        }

        int[] output = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            output[i] = prefixProds[i]*postfixProds[i];
        }

        return output;

    }
}  
