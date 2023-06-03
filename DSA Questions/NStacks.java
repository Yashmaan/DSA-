public class NStacks {
    private int[] data; // The array that stores the stack elements
    private int[] tops; // An array to keep track of the top of each stack
    private int[] nexts; // An array to keep track of the next element in each stack
    private int[] prevs; // An array to keep track of the previous element in each stack
    private int free; // The index of the first free element in the array

    public NStacks(int n, int capacity) {
        data = new int[capacity];
        tops = new int[n];
        nexts = new int[capacity];
        prevs = new int[capacity];
        free = 0;

        // Initialize the tops array to -1, indicating that each stack is empty
        for (int i = 0; i < n; i++) {
            tops[i] = -1;
        }

        // Initialize the nexts array to point to the next element in the array
        for (int i = 0; i < capacity - 1; i++) {
            nexts[i] = i + 1;
        }
        nexts[capacity - 1] = -1;

        // Initialize the prevs array to point to the previous element in the array
        for (int i = 1; i < capacity; i++) {
            prevs[i] = i - 1;
        }
        prevs[0] = -1;
    }

    public boolean isEmpty(int stackNum) {
        return tops[stackNum] == -1;
    }

    public boolean isFull() {
        return free == -1;
    }

    public void push(int stackNum, int value) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }

        int index = free;
        free = nexts[index];
        data[index] = value;
        prevs[index] = tops[stackNum];
        tops[stackNum] = index;

        if (prevs[index] != -1) {
            nexts[prevs[index]] = index;
        }
    }

    public int pop(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException("Stack underflow");
        }

        int index = tops[stackNum];
        tops[stackNum] = prevs[index];
        nexts[index] = free;
        free = index;

        if (tops[stackNum] != -1) {
            prevs[tops[stackNum]] = -1;
        }

        return data[index];
    }

    public int peek(int stackNum) {
        if (isEmpty(stackNum)) {
            throw new RuntimeException("Stack underflow");
        }

        return data[tops[stackNum]];
    }

    public static void main(String[] args) {
        NStacks nStacks = new NStacks(3, 9);

        nStacks.push(0, 1);
        nStacks.push(1, 2);
        nStacks.push(2, 3);

        nStacks.push(0, 4);
        nStacks.push(1, 5);
        nStacks.push(2, 6);

        nStacks.push(0, 7);
        nStacks.push(1, 8);
        nStacks.push(2, 9);

        System.out.println(nStacks.pop(0));
}
}