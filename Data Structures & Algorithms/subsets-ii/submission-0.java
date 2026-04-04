class Solution {
    Set<List<Integer>> listSet = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSubsets(nums, res, list, 0);
        return res;
    }

    private void backtrackSubsets(int[] nums, List<List<Integer>> res, List<Integer> list, int i) {

        if(i==nums.length){
            List<Integer> newList = new ArrayList<>(list);
            if(!listSet.contains(newList)){
                res.add(newList);
                listSet.add(newList);
            }
            return;
        }

        backtrackSubsets(nums, res, list, i+1);

        list.add(nums[i]);
        backtrackSubsets(nums, res, list, i+1);
        list.remove(list.size()-1);

    }
}
