class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] retarr = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                retarr[0] = map.get(target-nums[i]);
                retarr[1] = i;
                return retarr;

            } else {
                map.put(nums[i], i);
            }
        }
        return retarr;
    }
}
