class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrackList(list, res, nums, 0);
        return res;
    }

   // doing it using "for loop and start" way
    private void backtrackList(List<Integer> list, List<List<Integer>> res, int[] nums, int start) {

        res.add(new ArrayList<>(list));

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            backtrackList(list, res, nums, i+1);
            list.remove(list.size()-1);
        }

    }
}
