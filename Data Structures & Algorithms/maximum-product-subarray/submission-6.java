class Solution {
    public int maxProduct(int[] nums) {
        int overall = nums[0];          // best so far
        int lppeh = nums[0];            // max product ending here
        int lnpeh = nums[0];            // min product ending here

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            // similar idea to your lppeh / lnpeh, but use old values safely
            int cand1 = x;
            int cand2 = x * lppeh;
            int cand3 = x * lnpeh;

            lppeh = Math.max(cand1, Math.max(cand2, cand3));
            lnpeh = Math.min(cand1, Math.min(cand2, cand3));

            overall = Math.max(overall, lppeh);
        }

        return overall;
    }
}