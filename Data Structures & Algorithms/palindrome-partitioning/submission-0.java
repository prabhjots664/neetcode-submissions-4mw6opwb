class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        partitionRecurse(s, resList, res);
        return res;
    }

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

    private void partitionRecurse(String str, List<String> resList, List<List<String>> res) {

        if(str.isBlank() && !resList.isEmpty()){
            res.add(new ArrayList<>(resList));
        }

        for (int i = 0; i < str.length(); i++) {
            String preStr = str.substring(0, i+1);
            String postStr = "";
            if(i+1 < str.length()){
                postStr = str.substring(i+1);
            }

            if(!preStr.isBlank() && isPalindrome(preStr)){
                resList.add(preStr);

                partitionRecurse(postStr, resList, res);

                resList.remove(resList.size()-1);
            }

        }

    }
}
