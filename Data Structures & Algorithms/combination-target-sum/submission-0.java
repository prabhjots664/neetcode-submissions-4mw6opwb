class Solution {
     public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtrackSums(list, res, nums, target, 0, 0);
        return res;
    }

    private void backtrackSums(List<Integer> list, List<List<Integer>> res, int[] nums, int target, int currentSum, int start) {
        if(currentSum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(currentSum > target){
            return;
        }

        for (int j = start; j < nums.length; j++) {
            list.add(nums[j]);
            backtrackSums(list, res, nums, target, currentSum+nums[j], j);
            list.remove(list.size()-1);
        }

    }
}
