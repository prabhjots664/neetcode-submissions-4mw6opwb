class Solution {
    public int largestRectangleArea(int[] h) {
        int[] leftSme = new int[h.length];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<h.length;i++){
            while(!st.isEmpty() && h[st.peek()]>=h[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                leftSme[i] = st.peek();
            } else {
                leftSme[i] = -1;
            }
            st.push(i);
        }

        int[] rightSme = new int[h.length];
        st = new Stack<>();
        for(int i =h.length-1;i>=0;i--){
            while(!st.isEmpty() && h[st.peek()]>=h[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                rightSme[i] = st.peek();
            } else {
                rightSme[i] = h.length;
            }
            st.push(i);
        }

        int longestRectOfHI = -1;
        for(int i =0;i<h.length;i++){
            longestRectOfHI = Math.max(longestRectOfHI, (rightSme[i]-leftSme[i]-1)*h[i]);
        }
        return longestRectOfHI;
    }
}
