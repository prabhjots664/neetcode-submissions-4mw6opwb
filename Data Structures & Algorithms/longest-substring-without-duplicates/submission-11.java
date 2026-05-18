class Solution {
    public int lengthOfLongestSubstring(String s) {
        // if(s.isBlank()) return 0;
        
        Set<Character> set = new HashSet<>();
        int left = 0, longest = 0;
        for (int right = 0; right < s.length(); right++) {
            if(set.contains(s.charAt(right))){
                //remove existing elements from set through left   
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                if(s.charAt(left) == s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            if(longest< right -left+1){
                longest = right-left+1;
            }
        }
        return longest;
    }
}
