class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSums2(list, res, nums, target, 0);
        return res;
    }

    private void backtrackSums2(List<Integer> list, List<List<Integer>> res, int[] nums, int target, int start) {
        if(target==0){
            res.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }

        for (int i = start; i < nums.length; i++) {
            
            if(i>start && nums[i]==nums[i-1]){
                continue;
            } 
            
            list.add(nums[i]);
            backtrackSums2(list, res, nums, target-nums[i], i+1);
            list.remove(list.size()-1);
        }

    }
    
}
