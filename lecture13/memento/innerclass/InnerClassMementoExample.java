package lecture13.memento.innerclass;

import java.util.Stack;

// Client class
public class InnerClassMementoExample {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandHistory history = new CommandHistory();

        // Set initial state
        editor.setText("Hello World");
        editor.setCursor(0, 5);
        editor.setSelectionWidth(5);
        history.push(editor.createSnapshot());
        System.out.println(editor);

        // Modify state
        editor.setText("Hello Design Patterns");
        editor.setCursor(0, 17);
        history.push(editor.createSnapshot());
        System.out.println(editor);

        editor.setText("Not saved changes");
        editor.setCursor(62, 88);
        System.out.println(editor);

        // restore to last save
        Editor.Snapshot snapshot = history.pop();
        if (snapshot != null) {
            editor.restore(snapshot);
        }
        System.out.println();
        System.out.println("Restored to last save:");
        System.out.println(editor);
    }
}
// Originator class
class Editor {
    private String text;
    private int cursorX;
    private int cursorY;
    private int selectionWidth;

    public void setText(String text) {
        this.text = text;
    }

    public void setCursor(int x, int y) {
        this.cursorX = x;
        this.cursorY = y;
    }

    public void setSelectionWidth(int width) {
        this.selectionWidth = width;
    }

    // Method to create a snapshot of the current state
    public Snapshot createSnapshot() {
        return new Snapshot();
    }

    // Method to restore the editor state from a snapshot
    public void restore(Snapshot snapshot) {
        snapshot.restore();
    }

    @Override
    public String toString() {
        return "Editor{text='" + text + "', cursorX=" + cursorX + ", cursorY=" + cursorY + ", selectionWidth=" + selectionWidth + "}";
    }

    // Memento class
    class Snapshot {
        private final String text;
        private final int cursorX;
        private final int cursorY;
        private final int selectionWidth;

        // Constructor to capture the current state of the editor
        private Snapshot() {
            this.text = Editor.this.text;
            this.cursorX = Editor.this.cursorX;
            this.cursorY = Editor.this.cursorY;
            this.selectionWidth = Editor.this.selectionWidth;
        }

        // Method to restore the editor state
        private void restore() {
            Editor.this.text = this.text;
            Editor.this.cursorX = this.cursorX;
            Editor.this.cursorY = this.cursorY;
            Editor.this.selectionWidth = this.selectionWidth;
        }
    }
}



// Caretaker class
class CommandHistory {
    private final Stack<Editor.Snapshot> history = new Stack<>();

    public void push(Editor.Snapshot snapshot) {
        history.push(snapshot);
    }

    public Editor.Snapshot pop() {
        return history.isEmpty() ? null : history.pop();
    }
}



