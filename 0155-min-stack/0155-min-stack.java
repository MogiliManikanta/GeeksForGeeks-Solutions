class MinStack {
    Stack<Long> stack;  // Stack to store long values (either normal or encoded values)
    Long mini = Long.MAX_VALUE;  // To keep track of the minimum element

    public MinStack() {
        stack = new Stack<>();  // Initialize an empty stack
    }

    // Push a value into the stack
    public void push(int val) {
        long value = val;  // Cast int to long for consistency
        if (stack.isEmpty()) {  // If the stack is empty, this is the first element
            stack.push(value);  // Push the value as it is
            mini = value;  // Set the minimum to this value since it's the only one
        } else {
            if (value > mini) {  // If the new value is greater than the current minimum
                stack.push(value);  // Push the value as it is
            } else {
                // If the new value is smaller than or equal to the minimum, we store an encoded value
                long newVal = 2 * value - mini;  // Encode the new value using the formula
                stack.push(newVal);  // Push the encoded value onto the stack
                mini = value;  // Update the minimum to the new value
            }
        }
    }

    // Pop a value from the stack
    public void pop() {
        if (stack.isEmpty()) return;  // If the stack is empty, nothing to pop
        long popElement = stack.pop();  // Get the top element (either normal or encoded)

        if (popElement < mini) {  // If the popped element is less than the current minimum
            // This means it's an encoded value, so we need to restore the previous minimum
            mini = 2 * mini - popElement;  // Restore the previous minimum using the formula
        }
    }

    // Get the top element of the stack
    public int top() {
        if (stack.isEmpty()) return -1;  // Return -1 if the stack is empty
        long element = stack.peek();  // Peek the top element of the stack
        
        if (element < mini) {  // If it's encoded (less than the current minimum)
            return mini.intValue();  // Return the current minimum
        }
        return (int) element;  // Otherwise, return the actual element
    }

    // Get the minimum value in the stack
    public int getMin() {
        return mini.intValue();  // Return the current minimum
    }
}



 /***
 
 class Pair{
    int first;
    int second;
    Pair(int first,int second) {
        this.first=first;
        this.second=second;
    }
}
class MinStack {
    Stack<Pair>stack;
    int mini = (int)1e9;
    public MinStack() {
        stack = new Stack<>();
    }
    public void push(int val) {
      if(stack.isEmpty()){
            stack.push(new Pair(val,val));
            mini=val;
      }
      else{
        mini = Math.min(val,stack.peek().second);
        stack.push(new Pair(val,mini));
      }   
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().first;
    }
    
    public int getMin() {
        return stack.peek().second;
    }
}
  */