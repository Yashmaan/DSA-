public class CircularQueue {

    private int[] data;
    private int front, rear;
    private int size, capacity;

    public CircularQueue(int k) {
        data = new int[k];
        front = rear = -1;
        size = 0;
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        if (isEmpty())
            front = 0;

        rear = (rear + 1) % capacity;
        data[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }

        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return data[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return data[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
    
    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.enQueue(5);

        System.out.println("Front element is: " + q.Front());
        System.out.println("Rear element is: " + q.Rear());
        System.out.println("Queue size is: " + q.size);

        q.deQueue();
        q.enQueue(6);

        System.out.println("Front element is: " + q.Front());
        System.out.println("Rear element is: " + q.Rear());
        System.out.println("Queue size is: " + q.size);
    }
}
