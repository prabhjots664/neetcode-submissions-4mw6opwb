class Solution {
     public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> lists = new HashSet<>();


        for (int i = 0; i < nums.length-1; i++) {
            List<Integer> list = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                int numk = -nums[i]-nums[j];

                if(set.contains(numk)){
                    list.add(nums[i]);list.add(nums[j]);list.add(numk);
                    Collections.sort(list);
                    if(!lists.contains(list)){
                        lists.add(list);
                        
                    }
                    list = new ArrayList<>();
                }
                //add to set but why??????????? i am just reclling but not thinking clearly.. all brain rot and cloudiness
                set.add(nums[j]);
            }

        }

        return lists.stream().toList();
    }
}
