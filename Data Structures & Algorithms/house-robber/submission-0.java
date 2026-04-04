class Solution {
     public int rob(int[] nums) {

        int n = nums.length;
        int[] vals = new int[n+1];
        Arrays.fill(vals, -1);
        return robValue(nums, n, vals);

    }

    public int robValue(int[] nums, int n, int vals[]) {

        if(n<=0) return 0;
        if(n==1) return nums[n-1];

        if(vals[n-1]!=-1) return vals[n-1];

        vals[n-1] = Math.max( nums[n-1] + robValue(nums, n-2, vals) , nums[n-2] + robValue(nums, n-3, vals) );
        return vals[n-1];

    }
}
