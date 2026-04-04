class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsets(nums, res, list, 0);
        return res;
    }

    //trying to optimize by avoiding duplicates during recursion itself.
    //Input: nums = [1,1,2]
    private void backtrackSubsets(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {

        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            if(i>start && nums[i]==nums[i-1]){
                continue;
            }

            list.add(nums[i]);
            backtrackSubsets(nums, res, list, i+1);
            list.remove(list.size()-1);
        }

    }
}
