class Solution {
    public int findTargetSumWays(int[] nums, int target) {
    Map<String, Integer> memo = new HashMap<>();
    return ways(nums, nums.length - 1, target, memo);
}

private int ways(int[] nums, int i, int target, Map<String, Integer> memo) {
    if (i == -1 && target == 0) return 1;
    if (i == -1) return 0;

    String key = i + "," + target;
    if (memo.containsKey(key)) return memo.get(key);

    int count = ways(nums, i - 1, target + nums[i], memo)
              + ways(nums, i - 1, target - nums[i], memo);
    memo.put(key, count);
    return count;
}

}
