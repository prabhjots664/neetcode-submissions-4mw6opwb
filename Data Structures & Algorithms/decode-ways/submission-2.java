class Solution {
    public int numDecodings(String s) {
        Map<String, Character> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put(String.valueOf(i+1), (char)('A'+i));
        }
        return helper(s, map);
    }

    int helper(String s, Map<String, Character> map){
        if(s.length() == 0){  // Fix: return 1, not 0
            return 1;
        }

        String str1 = s.substring(0,1);
        int a = 0;
        if(map.containsKey(str1)){  // Simplified: always check, no special length
            a = helper(s.substring(1), map);
        }

        int b = 0;
        if(s.length() > 1){
            String str2 = s.substring(0,2);
            if(map.containsKey(str2)){  // Fix: recurse if valid, no "==2 &&" special case
                b = helper(s.substring(2), map);
            }
        }
        
        return a + b;
    }
}
