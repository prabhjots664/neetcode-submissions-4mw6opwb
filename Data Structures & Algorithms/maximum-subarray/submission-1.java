class Solution {
    public int maxSubArray(int[] nums) {
        int overallRes = -1, res =0;

        for(int i=0;i<nums.length;i++){
            int ele = nums[i];
            res+=ele;
            overallRes = Math.max(res,overallRes);

            if(res<0){
                res=0;
            }
        }

        return overallRes;
    }
}
