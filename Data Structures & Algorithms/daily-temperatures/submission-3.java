class Solution {
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n], result = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temps[st.peek()]<temps[i]){
                res[st.peek()] = i;
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
                res[st.peek()] = 0;
                st.pop();
        }

        for(int i=0;i<n;i++){
            if(res[i]!=0){
                result[i] = res[i] - i;
            }
        }

        return result;
    }
}
