class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        List<Integer> resList = new ArrayList<>();
        backtrackPermute(res, list, resList);
        return res;
    }

    private void backtrackPermute(List<List<Integer>> res, List<Integer> list, List<Integer> resList) {
        if(list.isEmpty()){
            res.add(new ArrayList<>(resList));
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            resList.add(list.remove(i));
            
            //recurse with backtrack method
            backtrackPermute(res, list, resList);
            
            list.add(i, resList.remove(resList.size()-1));
        }
        
    }
}
