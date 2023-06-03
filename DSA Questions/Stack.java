public class Stack {
    private int[] array;
    private int top;
    private int size;
    
    public Stack(int size) {
        this.array = new int[size];
        this.top = -1;
        this.size = size;
    }
    
    public boolean isEmpty() {
        return (top == -1);
    }
    
    public boolean isFull() {
        return (top == size-1);
    }
    
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        array[++top] = data;
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }
        return array[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return array[top];
    }
    
    public void printStack() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
 public static void main(String args[]){

Stack stack = new Stack(5);

stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
stack.push(5);

stack.printStack(); // Output: Stack: 1 2 3 4 5

System.out.println(stack.pop()); // Output: 5

System.out.println(stack.peek()); // Output: 4

stack.printStack(); // Output: Stack: 1 2 3 4
}
}

