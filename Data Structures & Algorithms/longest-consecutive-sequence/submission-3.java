class Solution {
     public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        if(nums.length==0) return 0;

        for (int num : nums) {
            set.add(num);
        }

        int lcs = 1;
        for (int num: set){
            if(!set.contains(num+1)){
                int longest = 1;
                int val = num;
                while(set.contains(val-1)) {
                    longest++;
                    val--;
                }

                if(lcs<longest){
                    lcs = longest;
                }
            }
        }

        return lcs;
    }
}
