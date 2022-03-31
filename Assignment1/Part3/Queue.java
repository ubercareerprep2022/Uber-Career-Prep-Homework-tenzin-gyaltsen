package Assignment1.Part3;

public class Queue {
    private int arr[];
    private int front;
    private int rear;
    private int size;
    private int count;
    
    public Queue (int size) {
        arr = new int[size];
        this.size = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue (int value) {
        if(count == size) {
            System.out.println("Queue is full, can't enqueue more");
            System.exit(-1);
        }
        arr[++rear] = value;
        count++;
    }

    public int dequeue () {
        if (count == 0) {
            System.out.println("Queue is empty, can't dequeue more");
            System.exit(-1);
        }

        int dequeNum = arr[front];

        count--;

        return dequeNum;
    }

    
}
