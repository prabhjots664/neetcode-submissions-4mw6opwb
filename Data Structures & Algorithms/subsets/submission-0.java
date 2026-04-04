class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrackList(list, res, nums, 0);
        return res;
    }

    private void backtrackList(List<Integer> list, List<List<Integer>> res, int[] nums, int i) {

        if(i==nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        backtrackList(list, res, nums, i+1);

        list.add(nums[i]);
        backtrackList(list, res, nums, i+1);
        list.remove(list.size()-1);

    }
}
