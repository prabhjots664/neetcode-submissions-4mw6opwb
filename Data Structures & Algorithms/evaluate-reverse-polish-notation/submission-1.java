class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");set.add("-");set.add("*");set.add("/");
        for(int i =0;i<tokens.length;i++){
            if(set.contains(tokens[i])){
                int a = st.pop();
                int b = st.pop();
                if(tokens[i].equals("+")){
                    st.push(a+b);
                } else if(tokens[i].equals("-")){
st.push(b-a);
                } else if(tokens[i].equals("*")){
st.push(a*b);
                } else {
st.push(b/a);
                }
            } else {
                st.push(Integer.parseInt(tokens[i]));
            }
        }

        return st.peek();
    }
}
