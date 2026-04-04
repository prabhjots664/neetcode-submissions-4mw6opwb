class Solution {

    Map<String, Boolean> map = new HashMap<>();

    boolean isPalin(String str){
        if(str.length()==0) return true;
        if(map.containsKey(str)){
            return map.get(str);
        }

        int i =0,j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)){
                map.put(str, Boolean.FALSE);
                return false;
            }
            i++;
            j--;
        }
        map.put(str, Boolean.TRUE);
        return true;
    }

    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        helper(s,list, res);

        return res;
    }

    void helper(String s, List<String> list, List<List<String>> res){
        if(s.isEmpty() && !list.isEmpty()){
            res.add(new ArrayList<>(list));
        }

        for(int i=1;i<=s.length();i++){
            String str = s.substring(0,i);
            if(isPalin(str)){
                list.add(str);
                helper(s.substring(i), list, res);
                list.remove(list.size()-1);
            }
        }
    }
}
