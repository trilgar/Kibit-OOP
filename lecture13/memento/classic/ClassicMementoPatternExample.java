
package lecture13.memento.classic;

import java.util.ArrayList;
import java.util.List;

public class ClassicMementoPatternExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        History history = new History();

        editor.setText("Hello");
        editor.setCursor(0, 5);
        editor.setSelectionWidth(5);
        history.push(editor.createSnapshot());
        System.out.println(editor);

        editor.setText("Hello, World!");
        editor.setCursor(0, 13);
        history.push(editor.createSnapshot());
        System.out.println(editor);

        editor.setText("New Text");
        editor.setCursor(0, 8);
        System.out.println(editor);

        // Undo to previous state
        editor.restore(history.pop());
        System.out.println();
        System.out.println("Restored to previous state:");
        System.out.println(editor);

        // Undo to the original state
        editor.restore(history.pop());
        System.out.println();
        System.out.println("Restored to original state:");
        System.out.println(editor);
    }
}


// Originator class
class Editor {
    private String text;
    private int curX, curY;
    private int selectionWidth;

    public void setText(String text) {
        this.text = text;
    }

    public void setCursor(int x, int y) {
        this.curX = x;
        this.curY = y;
    }

    public void setSelectionWidth(int width) {
        this.selectionWidth = width;
    }

    public Memento createSnapshot() {
        return new EditorMemento(text, curX, curY, selectionWidth);
    }

    public void restore(Memento memento) {
        if (memento instanceof EditorMemento) {
            EditorMemento editorMemento = (EditorMemento) memento;
            this.text = editorMemento.getText();
            this.curX = editorMemento.getCurX();
            this.curY = editorMemento.getCurY();
            this.selectionWidth = editorMemento.getSelectionWidth();
        }
    }

    @Override
    public String toString() {
        return "Editor{text='" + text + "', curX=" + curX + ", curY=" + curY + ", selectionWidth=" + selectionWidth + "}";
    }
}

interface Memento {}


// ConcreteMemento class
class EditorMemento implements Memento {
    private final String text;
    private final int curX, curY;
    private final int selectionWidth;

    public EditorMemento(String text, int curX, int curY, int selectionWidth) {
        this.text = text;
        this.curX = curX;
        this.curY = curY;
        this.selectionWidth = selectionWidth;
    }

    public String getText() {
        return text;
    }

    public int getCurX() {
        return curX;
    }

    public int getCurY() {
        return curY;
    }

    public int getSelectionWidth() {
        return selectionWidth;
    }
}

// Caretaker class
class History {
    private final List<Memento> history = new ArrayList<>();

    public void push(Memento memento) {
        history.add(memento);
    }

    public Memento pop() {
        if (!history.isEmpty()) {
            return history.removeLast();
        }
        return null;
    }
}
