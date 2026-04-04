class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int minLength = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;

        while (i<=j && j<nums.length){

            while (sum<target && j<nums.length){
                sum += nums[j];
                j++;
            }


            while (sum>=target && i<j){

                if(minLength > j-i){
                    minLength = j-i;
                }
                sum -= nums[i];
                i++;
            }

        }

        if(minLength == Integer.MAX_VALUE){
            return 0;
        }


        return minLength;
    }
}