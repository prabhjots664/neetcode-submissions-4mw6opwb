class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(Integer num: nums){
            set.add(num);
        }
        int res = 0;
        for(Integer num : set){
            if(!set.contains(num-1)){
                int count = 0, temp = num;
                while(set.contains(temp)){
                    count++;
                    temp++;
                }
                res = Math.max(res,count);
            }
            
        }

        return res;
    }
}
