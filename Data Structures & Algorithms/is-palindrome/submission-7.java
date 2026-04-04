class Solution {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        if(s.isBlank() || s.length()==1) return true;

        int left = 0; int right = s.length()-1;

        while (left < right){
            //move left and right ahead until they are at a alphanumeric chars
            while( left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while( left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if(left > right ) return false;

            // if left and right cahrs are not equal , return false
            if(s.charAt(left) != s.charAt(right)) return false;

            // increement both left and right and repeat step 1
            left++;right--;
        }

        return true;
    }
}
