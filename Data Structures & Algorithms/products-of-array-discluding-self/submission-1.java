class Solution {
     public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
//        nums=[-1,0,1,2,3]
        int[] prefixProducts = new int[nums.length];
        int[] postfixProducts = new int[nums.length];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i-1>=0) {
                product *= nums[i-1];
            }
            prefixProducts[i] = product;
        }

        System.out.println("prefix array is:" + Arrays.toString(prefixProducts));

        product = 1;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(i+1 < nums.length){
                product *= nums[i+1];
            }
            postfixProducts[i] = product;
        }

        System.out.println("postfix array is:" + Arrays.toString(postfixProducts));

        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProducts[i] * postfixProducts[i];
        }

        return res;
    }
}  
