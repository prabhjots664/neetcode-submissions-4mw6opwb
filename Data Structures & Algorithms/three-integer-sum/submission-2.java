class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length-2;i++){
            int l=i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==0){
                    List<Integer> list = List.of(nums[i],nums[l],nums[r]);
                    if(!set.contains(list)){
                        res.add(list);
                        set.add(list);
                    }
                } 
                
                if( sum<=0 ){
                    l++;
                } else {
                    r--;
                }

            }
        }

        return res;
    }
}
