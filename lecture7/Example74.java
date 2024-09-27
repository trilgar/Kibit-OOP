package lecture7;

public class Example74 {
}

class EmptyStack extends Exception {
}

class FullStack extends Exception {
}

class Stack {
    private int height;
    private Object items[];

    public void push(Object x) throws FullStack {
        if (items.length == height) throw new FullStack();
        items[height++] = x;
    }

    public Object pop() throws EmptyStack {
        if (height == 0)
            throw new EmptyStack();
        return (items[--height]);
    }

    private void init(int s) {
        height = 0;
        items = new Object[s];
    }

    public Stack(int s) {
        init(s);
    }

    public Stack() {
        init(10);
    }
}

class Parser {
    void expression() {
        Stack s = new Stack();
        int x = 0;
        try {
            s.push(x);
        } catch (FullStack e) { // respond to full stack condition
            System.out.println("expression nesting exceeds implementation limit");
            abort();
        } catch (Exception ex) {
            // other possible exceptions
        }
    }
    void abort() {
        // handle the error
    }
}

class Evaluator {
    Stack s = new Stack();
    void operand() {
        Integer value;
        try {
            value = (Integer) s.pop();
        } catch (EmptyStack e) {
            // respond to empty stack condition
            value = 0;
        }
    }
}