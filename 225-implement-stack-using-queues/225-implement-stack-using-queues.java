class MyStack {
    Queue<Integer> firstQueue;
    Queue<Integer> secondQueue;

    public MyStack() {
        firstQueue = new LinkedList<>();
        secondQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        secondQueue.offer(x);
        
        while(!firstQueue.isEmpty()) {
            secondQueue.offer(firstQueue.poll());
        }
        
        Queue<Integer> queue = secondQueue;
        secondQueue = firstQueue;
        firstQueue = queue;
    }
    
    public int pop() {
        if(firstQueue.isEmpty()) return -1;
        return firstQueue.poll();
    }
    
    public int top() {
        if(firstQueue.isEmpty()) return -1;
        return firstQueue.peek();
    }
    
    public boolean empty() {
        return firstQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */