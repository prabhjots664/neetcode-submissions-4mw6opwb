class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res =  new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        subsetsWithDup2Backtrack(nums, res, list ,0);

        return res;
    }

    private void subsetsWithDup2Backtrack(int[] nums, List<List<Integer>> res, List<Integer> list ,  int start) {
        
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            if(i==start || (i>start && nums[i]!=nums[i-1])){
                list.add(nums[i]);
                subsetsWithDup2Backtrack(nums, res, list, i+1);
                list.remove(list.size()-1);
            }
        }
        
    }
}
