class Solution {

   boolean isPalindrome(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    String recurPalin(String s, int i, int j, Map<String , String> map){

        if(i>j) return null;

        String str = s.substring(i, j);
        String res = "", res1 = "", res2="", res3="";
        
        if(map.containsKey(str)){
            return map.get(str);
        }

        if(isPalindrome(str)){
            res = str;
        } else {
            if(!recurPalin(s, i+1, j, map).isBlank()) res1 = recurPalin(s, i+1, j, map);

            if(!recurPalin(s, i, j-1, map).isBlank()) res2 = recurPalin(s, i, j-1, map);

            if(!recurPalin(s, i+1, j-1, map).isBlank()) res3 = recurPalin(s, i+1, j-1, map);

            if(res1.length()>res2.length()){
                res = res1;
            } else {
                res = res2;
            }

            if(res3.length()>res.length()){
                res = res3;
            }
        }

        map.put(str, res);
        return res;
    }

    //Input: s = "ababd"
    //Output: "bab"
    public String longestPalindrome(String s) {

        int i =0, j = s.length();
        Map<String, String> map = new HashMap<>();
        return recurPalin(s, i, j, map);

    }

}
