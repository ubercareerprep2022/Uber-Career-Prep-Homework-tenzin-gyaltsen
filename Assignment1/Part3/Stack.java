package Assignment1.Part3;

public class Stack {
    private int arr[];
    private int top = -1;
    private int size;

    public Stack (int size) {
        arr = new int[size];
        this.size = size;
        top = -1;
    }

    public void push (int input) {
        if(top == size - 1) {
            System.out.println("Stack is full, cannot push any new elements");
            System.exit(-1);
        } else {
            arr[++top] = input;
        }
        
    }

    public int pop () {
        if (isEmpty()) {
            System.out.println("No elements in the stack");
            System.exit(-1);
        }  
        return arr[top--];   
    }

    public int top () {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.exit(-1);
        }
        return -1;
    }

    public boolean isEmpty () {
        return top == -1;
    }

    public int size () {
        return top + 1;
    }


    public static void main(String[] args) {
        Stack myStack = new Stack(100);
        myStack.push(42);
        System.out.println("Top of stack: "+ myStack.top());
            // prints “Top of stack: 42”
        
        System.out.println("Size of stack: " + myStack.size());
            // prints “Size of stack: 1”

        int poppedValue = myStack.pop();
        System.out.println("Popped value: " + poppedValue);
            // prints “Popped value: 42”

        System.out.println("Size of stack: " + myStack.size());
            //prints “Size of stack: 0”
        
        System.out.println("Popped value:" + myStack.pop());
            //prints "-1"

    }


    
}
