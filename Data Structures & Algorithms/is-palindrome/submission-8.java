class Solution {
    
    public boolean isPalindrome(String s) {

        s= s.toLowerCase();
        int n = s.length();
        int i=0,j=n-1;

        while(i<j){

            while(!Character.isLetterOrDigit(s.charAt(i)) && i<j) i++;
            while(!Character.isLetterOrDigit(s.charAt(j)) && i<j) j--;

            if(s.charAt(i)!=s.charAt(j)) return false;

            i++;j--;

        }

        return true;
    }

}
