class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorTotal = 0;


        for(int i = 0; i<n; i++){
            xorTotal ^= i;
            xorTotal ^= nums[i];
        }

        return xorTotal^n;
    }
}
