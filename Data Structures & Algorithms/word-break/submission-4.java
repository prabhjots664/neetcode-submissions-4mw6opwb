class Solution {
   public boolean wordBreak(String s, List<String> dict) {
        Map<String, Boolean> map = new HashMap<>();
        return wordBreakDp(s, dict, map);
    }

    public boolean wordBreakDp(String s, List<String> dict, Map<String, Boolean> map){

        if(s.isBlank()){
            return true;
        }

        if(s.length()==1 && !dict.contains(s)){
            return false;
        }
        
        if(map.containsKey(s)){
            return map.get(s);
        }

        boolean res = false;

        for (int i = 0; i < s.length(); i++) {
            String leftStr = s.substring(0, i+1);
            String rightStr = "";
            if(i<s.length()-1){
                rightStr = s.substring(i+1);
            }

            if(dict.contains(leftStr)){
                res = res || wordBreakDp(rightStr, dict, map);
            }

        }

        map.put(s, res);
        return res;

    }
}
