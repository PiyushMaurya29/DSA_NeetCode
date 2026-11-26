class MaxStack {
    Stack<int[]> stack;
    public MaxStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x, x});
        }
        else{
            stack.push(new int[]{x, Math.max(x, stack.peek()[1])});
        }
    }
    
    public int pop() {
        if(stack.isEmpty()) return -1;
        return stack.pop()[0];
    }
    
    public int top() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[0];
    }
    
    public int peekMax() {
        if(stack.isEmpty()) return -1;
        return stack.peek()[1];
    }
    
    public int popMax() {
        if(stack.isEmpty()) return -1;
        int currMax = stack.peek()[1];
        List<int[]> list = new ArrayList<>();
        while(stack.peek()[0] != currMax){
            list.add(stack.pop());
        }
        int max = stack.pop()[0];
        for(int i=list.size()-1 ; i>=0 ; i--){
            stack.push(list.get(i));
        }
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
