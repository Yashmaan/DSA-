public class Queue {


    int[] array;
     int front;
     int rear;
    int size;
    
     Queue(int size) {
        this.array = new int[size];
        this.front = 0;
        this.rear = -1;
        this.size = size;
    }
    
    public boolean isEmpty() {
        return (rear < front);
    }
    
    public boolean isFull() {
        return (rear == size-1);
    }
    
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue overflow");
            return;
        }
        array[++rear] = data;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }
        return array[front++];
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return array[front];
    }
    
    public void printQueue() {
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


 public static void main(String args[]){

Queue Q = new Queue(5);

Q.enqueue(1);
Q.enqueue(2);
Q.enqueue(3);
Q.enqueue(4);
Q.enqueue(5);

Q.printQueue(); // Output: Queue: 1 2 3 4 5

System.out.println(Q.dequeue()); // Output: 1

System.out.println(Q.peek()); // Output: 2

Q.printQueue(); // Output: Queue: 2 3 4 5
}
}

