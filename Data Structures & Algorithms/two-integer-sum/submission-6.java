class Solution {
    public int[] twoSum(int[] nums, int t) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(t-nums[i])){
                return new int[]{map.get(t-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}
