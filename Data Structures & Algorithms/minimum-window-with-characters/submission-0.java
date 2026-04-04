class Solution {
    //Input: s = "OUZODYXAZV", t = "XYZ"
    // Output: "YXAZ"
    public String minWindow(String s, String t) {
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> countS = new HashMap<>();
        for(char c: t.toCharArray()){
            countT.put(c, countT.getOrDefault(c, 0)+1);
        }
        int need=countT.size(), have=0, minL=-1, minR=-1, minLen=Integer.MAX_VALUE;
        
        int l =0;
        for (int r = 0; r < s.length(); r++) {
            Character ch = s.charAt(r);
            countS.put(ch, countS.getOrDefault(ch, 0)+1);
            if(countT.containsKey(ch) && countS.get(ch)==countT.get(ch)){
                have++;
            }
            
            while(have==need && l<=r){
                int len = r-l+1;
                if(len<minLen){
                    minLen = len;
                    minL = l;
                    minR = r;
                }
                
                
                
                countS.put(s.charAt(l), countS.get(s.charAt(l))-1);
                if(countS.get(s.charAt(l)) < countT.getOrDefault(s.charAt(l), 0)){
                   have--;
                }
                l++;
            }
        }
        
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minL, minR+1);
        
    }
}
