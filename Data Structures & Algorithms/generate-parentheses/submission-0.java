class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        int countOpen = n, countClose = n;//open = +1, close = -1, valid if currCount >=0

        StringBuilder currSb = new StringBuilder();
        generateWithBacktracking(res, countOpen, countClose, 0, currSb);


        return res;
    }

    //res, 2, 2, 0, ""
    //"("
    private void generateWithBacktracking(List<String> res, int countOpen, int countClose, int currCount, StringBuilder currSb) {
        if(countClose==0 && countOpen==0){
            res.add(currSb.toString());
            return;
        }

        if(countOpen>0){
            currSb.append('(');
            generateWithBacktracking(res, countOpen-1, countClose, currCount+1, currSb);
            currSb.deleteCharAt(currSb.length()-1);
        }

        if(countClose>0 && currCount>0){
            currSb.append(')');
            generateWithBacktracking(res, countOpen, countClose-1, currCount-1, currSb);
            currSb.deleteCharAt(currSb.length()-1);
        }

    }
    
}
