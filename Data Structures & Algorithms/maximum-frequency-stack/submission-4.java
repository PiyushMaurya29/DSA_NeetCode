class FreqStack {
    Map<Integer, Stack<Integer>> stackMap;
    Map<Integer, Integer> freqMap;
    int maxFreq;
    public FreqStack() {
        maxFreq = 0;
        stackMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0)+1;
        freqMap.put(val, freq);
        if(!stackMap.containsKey(freq)){
            stackMap.put(freq, new Stack<>());
        }
        stackMap.get(freq).add(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        Stack<Integer> stack = stackMap.get(maxFreq);
        int ans = stack.pop();
        freqMap.put(ans, freqMap.get(ans)-1);

        if(stack.isEmpty()){
            maxFreq--;
        }
        return ans;
    }
}



// class FreqStack {
//     Map<Integer, Stack<Integer>> map; // Frequency and Stack Map
//     Map<Integer, Integer> freqMap;
//     PriorityQueue<Integer> maxHeap;
//     public FreqStack() {
//         map = new HashMap<>();
//         freqMap = new HashMap<>();
//         maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//     }
    
//     public void push(int val) {
//         int freq = freqMap.getOrDefault(val, 0)+1;
//         if(!freqMap.containsKey(val)){
//             freqMap.put(val, freq);
//         }
//         freqMap.put(val, freq);
//         if(!map.containsKey(freq)){
//             map.put(freq, new Stack<>());
//         }
//         map.get(freq).add(val);
//         maxHeap.offer(freq);
//     }
    
//     public int pop() {
//         int maxFreq = maxHeap.poll();
//         int ans = map.get(maxFreq).pop();
//         freqMap.put(ans, freqMap.get(ans)-1);

//         return ans;
//     }
// }



// class FreqStack {
//     Stack<int[]> stack;
//     Map<Integer, Integer> freqMap;
//     public FreqStack() {
//         stack = new Stack<>();
//         freqMap = new HashMap<>();
//     }
    
//     public void push(int val) {
//         freqMap.put(val, freqMap.getOrDefault(val, 0)+1);
//         stack.push(new int[]{val, freqMap.get(val)});
//     }
    
//     public int getMaxFreq(Map<Integer, Integer> map){
//         int maxFreq = 0;
//         for(int key : map.keySet()){
//             int freq = map.get(key);
//             maxFreq = Math.max(maxFreq, freq);
//         }
//         return maxFreq;
//     }
//     public int pop() {
//         int maxFreq = getMaxFreq(freqMap);
//         Stack<int[]> temp = new Stack<>();
//         while(stack.peek()[1] != maxFreq){
//             temp.push(stack.pop());
//         }
//         int ans = stack.pop()[0];

//         freqMap.put(ans, freqMap.get(ans)-1);

//         while(!temp.isEmpty()){
//             stack.push(temp.pop());
//         }

//         return ans;
//     }
// }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */