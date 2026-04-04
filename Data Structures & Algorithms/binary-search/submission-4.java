class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, l = 0, r = n-1;

        while(l<=r){
            int m = l+(r-l)/2;
            if(target==nums[m]){
                return m;
            }
            if(target>=nums[l] && target<nums[m]){
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
