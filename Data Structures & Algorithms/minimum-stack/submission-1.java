class MinStack {

   Stack<Integer> stack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

    public MinStack() {
        
    }

     public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            int minTillLast = minStack.peek();
            if(minTillLast>val){
                minStack.push(val);
            }else {
                minStack.push(minTillLast);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
