class Solution {
    public boolean isComplementaryClosingBrace(Character a, Character b){
        if (a.equals('{') && b.equals('}')) return true;
        if (a.equals('(') && b.equals(')')) return true;
        if (a.equals('[') && b.equals(']')) return true;
        return false;
    }
    public boolean isValid(String s) {

        if(s.isBlank()) return true;
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if( !stack.isEmpty() && isComplementaryClosingBrace(stack.peek(), ch)){
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        if (stack.isEmpty()) return true;
        return false;
    }
}
