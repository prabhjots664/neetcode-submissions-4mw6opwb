class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        generateParenthesis2BackTracking(0, 0, n, res, "");

        return res;
    }

    private void generateParenthesis2BackTracking(int openCount, int closeCount, int n, List<String> res, String str) {

        if(openCount==n && closeCount==n){
            if(!str.isBlank()){
                res.add(str);
            }
            return;
        }
        
        // add an open bracket to str if opencount < n
        //backtrack
        if(openCount<n){
            generateParenthesis2BackTracking(openCount+1, closeCount, n, res, str + "(");
            //automatically backtracked since str +"(" is done and str remain same afterwards.
        }
        
        
        //if opencount>closecount and closecount < n
        //backtrack
        if(closeCount<n && closeCount<openCount){
            generateParenthesis2BackTracking(openCount, closeCount+1, n, res, str + ")");
        }
        

    }
}
