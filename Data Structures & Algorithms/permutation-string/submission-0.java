class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] cs1 = new int[26];
        int[] cs2 = new int[26];

        int need=0, have=0;
        for(int i = 0;i<s1.length();i++){
            if(cs1[s1.charAt(i)-'a']==0){
                need++;
            }
            cs1[s1.charAt(i)-'a']++;
        }

        int l=0,r=0;
        while(r<s2.length()){
            while(r-l+1>s1.length()){
                if(cs2[s2.charAt(l)-'a'] == cs1[s2.charAt(l)-'a']){
                   have--;
                }
                cs2[s2.charAt(l)-'a']--;
                l++;
            }

            cs2[s2.charAt(r)-'a']++;
            if(cs2[s2.charAt(r)-'a'] == cs1[s2.charAt(r)-'a']){
                have++;
            }

            if(need == have && r-l+1 == s1.length()){
                return true;
            }

            r++;

        }

        return false;
    }
}
