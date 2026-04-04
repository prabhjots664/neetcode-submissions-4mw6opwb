class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> map = new HashMap<>();
        return ways(nums, nums.length-1, target, map);
    }

    private int ways(int[] nums, int i, int target, Map<String, Integer> map) {
        if(i==-1 && target==0){
            return 1;
        }
        if(i==-1){
            return 0;
        }

        String key = i + ","  + target;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int ways =  ways(nums, i-1, target+nums[i], map) + ways(nums, i-1, target-nums[i], map);
        map.put(key, ways);
        return map.get(key);
    }
}
