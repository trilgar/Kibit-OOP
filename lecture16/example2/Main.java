package lecture16.example2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("stack size: " + stack.size());
        System.out.println("popped: " + stack.pop());
        System.out.println("popped: " + stack.pop());
        System.out.println("stack size: " + stack.size());
        stack.push(6);
        stack.push(7);
        stack.push("Hello");
        stack.push(9);
        stack.push(new Date(1000000));
        stack.push(11);
        System.out.println("stack size: " + stack.size());
        System.out.println("popped: " + stack.pop());
        System.out.println("popped: " + stack.pop());
        System.out.println("stack size: " + stack.size());
    }
}

class StackItem {
    private Object item = 0;
    private StackItem previous;

    public Object getItem() {
        return item;
    }

    public void setItem(Object x) {
        item = x;
    }

    public StackItem getPrevious() {
        return previous;
    }

    public void setPrevious(StackItem p) {
        previous = p;
    }

    public StackItem() {
        previous = null;
    }
}

class Stack {
    private StackItem top, temp;
    private int size = 10;

    public Object pop() {
        Object x = 0;
        if (empty()) {
            System.err.println("stack underflow");
        } else {
            x = top.getItem();
            top = top.getPrevious();
            size--;
        }
        return x;
    }

    public void push(Object x) {
        if (full()) {
            System.err.println("stack overflow");
        } else {
            temp = top;
            top = new StackItem();
            top.setPrevious(temp);
            top.setItem(x);
            size++;
            System.out.println("pushed " + x + " into stack");
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size() == 0;
    }

    public boolean full() {
        return false;
    }

    public Stack() {
        top = null;
        size = 0;
    }
}
