package Assignment1.Part3;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Integer> queueList;
    private int front;
    private int rear;
    private int count;
    
    public Queue () {
        queueList = new LinkedList<>();
        front = -1;
        rear = -1;
        count = 0;
    }

    public void enqueue (int value) {
        rear = value;
        queueList.add(value);
        front = queueList.getFirst();
        count++;
    }

    public int dequeue () {
        // Handles empty queue case
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue");
            return -1;
        } else{
            int dequeNum = front;
            queueList.removeLast();
            count--;
            
            // deals with front and rear value assignment if the dequeued item was the last one
            if(count == 0) {
                rear = -1;
                front = -1;
            } else {
                front = queueList.getFirst();
                rear = queueList.getLast();
            }
            return dequeNum;
        }
         
    }

    public int rear () {
        return rear;
    }

    public int front () {
        return front;
    }

    public int size () {
        return count;
    }

    public boolean isEmpty () {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        Queue myQueue = new Queue();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);

        System.out.println("Size of queue: " + myQueue.size());
        //prints “Size of queue: 3”

        System.out.println("Front of queue: " + myQueue.front());
        //prints “Front of queue: 1”

        System.out.println("Rear of queue: " + myQueue.rear());
        //prints “Rear of queue: 3”

        System.out.println();

        int dequeuedItem = myQueue.dequeue();
        System.out.println("Dequeue item: " +  dequeuedItem);
        //prints “Dequeued item: 1”

        System.out.println("Front of queue: " + myQueue.front());
        //prints “Front of queue: 2”

        System.out.println("Rear of queue: " + myQueue.rear());
        //prints “Rear of queue: 3”

        myQueue.dequeue();
        System.out.println("Size of queue: " + myQueue.size());
        // print size: 1

        myQueue.dequeue();
        System.out.println("Size of queue: " + myQueue.size());
        // prints size: 0

        myQueue.dequeue();
        // print "Queue is empty. Nothing to dequeue"

    }

    
}
