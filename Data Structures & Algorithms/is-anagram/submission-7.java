class Solution {
    public boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(char ch : t.toCharArray()){
            int freq = map.getOrDefault(ch,0)-1;
            if(freq<0){
                return false;
            } else if(freq==0){
                map.remove(ch);
            } else {
                map.put(ch, freq);
            }
            
        }

        return map.isEmpty();

    }
}
