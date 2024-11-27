package lecture16.example3;

class InvalidTypeException extends Exception {}

public class StackApp {
    private Stack s = new Stack();

    void pushInteger(Object o) throws InvalidTypeException {
        if (o instanceof Integer) s.push(o);
        else throw new InvalidTypeException();
    }

    public static void main(String args[]) {
        int numberOfItems;
        numberOfItems = 10;
        StackApp sapp = new StackApp();

        try {
            for (int i = 0; i < numberOfItems; i++) {
                sapp.pushInteger(i);
            }
            String str1 = "Testing ";
            sapp.pushInteger(str1 + 0);
        } catch (InvalidTypeException e) {
            System.out.println("WrongType pushed");
        }
    }
}

class StackItem {
    private Object item = 0;
    private StackItem previous;

    public Object getItem() { return item; }
    public void setItem(Object x) { item = x; }
    public StackItem getPrevious() { return previous; }
    public void setPrevious(StackItem p) { previous = p; }

    public StackItem() { previous = null; }
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

    public int size() { return size; }
    public boolean empty() { return size() == 0; }
    public boolean full() { return false; }

    public Stack() {
        top = null;
        size = 0;
    }
}
