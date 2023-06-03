class MinStack {
    int min;
    Stack<Integer> stack;

    public MinStack() {
        min = Integer.MAX_VALUE;
        Stack = new Stack();
    }

    public void push(int x) {
        if (x <= min) {
            // We need to push the current minimum onto the stack
            // before updating the new minimum value.
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }

        int poppedValue = stack.pop();

        if (poppedValue == min) {
            // If we have popped the current minimum, we need to update
            // the minimum to be the next value on the stack.
            if (!stack.isEmpty()) {
                min = stack.pop();
            } else {
                min = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
public static void main (String args[]){

MinStack stack = new MinStack();

stack.push(5);
System.out.println(stack.getMin()); // Output: 5

stack.push(3);
System.out.println(stack.getMin()); // Output: 3

stack.push(2);
System.out.println(stack.getMin()); // Output: 2

stack.pop();
System.out.println(stack.getMin()); // Output: 3

stack.pop();
System.out.println(stack.getMin()); // Output: 5
}
}
