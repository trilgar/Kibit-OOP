package lecture16.example4;

class StackItem<E> {
    private E item = null;
    private StackItem<E> previous;

    public E getItem() {
        return item;
    }

    public void setItem(E x) {
        item = x;
    }

    public StackItem<E> getPrevious() {
        return previous;
    }

    public void setPrevious(StackItem<E> p) {
        previous = p;
    }

    public StackItem() {
        previous = null;
    }
}

class Stack<E> {
    private StackItem<E> top, temp;
    private int size = 10;

    public E pop() {
        E x = null;
        if (empty()) System.err.println("stack underflow");
        else {
            x = top.getItem();
            top = top.getPrevious();
            size = size - 1;
        }
        return x;
    }

    public void push(E x) {
        if (full()) System.err.println("stack overflow");
        else {
            temp = top;
            top = new StackItem<E>();
            top.setPrevious(temp);
            top.setItem(x);
            size = size + 1;
            System.out.println("pushed " + x + " into stack");
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public boolean full() {
        return false;
    }

    public Stack() {
        top = null;
        size = 0;
    }
}

public class StackApp {
    public static void main(String[] args) {
        int numberOfItems;
        numberOfItems = 10;

        Stack<Integer> sInt = new Stack<>();
        for (int i = 0; i < numberOfItems; i++) {
            sInt.push(i);
        }

        Stack<String> sStr = new Stack<>();
        String str1 = "Testing with Generics ";
        for (int i = 0; i < numberOfItems; i++) {
            sStr.push(str1 + i);
        }
    }
}

