class Solution {

    // boolean isValid?

    public int numDecodings(String s) {
        Map<String, Character> map = new HashMap<>();
        Map<String, Integer> dpMap = new HashMap<>();

        for(int i =0;i<26;i++){
            map.put(String.valueOf(i+1), (char)('A'+i));
        }

        return helper(s,map, dpMap);

    }

    int helper(String s, Map<String, Character> map, Map<String, Integer> dpMap){
        if(s.length()==0){
            return 1;
        }

        if(dpMap.containsKey(s)){
            return dpMap.get(s);
        }

        String str1 = s.substring(0,1);
        int a = 0;
        if(map.containsKey(str1)){
            a = helper(s.substring(1), map, dpMap);
        }

        int b = 0;
        if(s.length()>1){
             str1 = s.substring(0,2);
            if(map.containsKey(str1)){
                b = helper(s.substring(2), map, dpMap);
            }
        }
        
        dpMap.put(s,a+b);
        return a + b;
    }
}
