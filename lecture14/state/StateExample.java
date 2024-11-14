package lecture14.state;

interface State {
    void publish(Document context);
    void render(Document context);
}

class Document {
    private State state;

    public Document() {
        this.state = new DraftState();
    }

    public void setState(State state) {
        this.state = state;
    }

    public void publish() {
        state.publish(this);
    }

    public void render() {
        state.render(this);
    }
}

class DraftState implements State {
    @Override
    public void publish(Document context) {
        System.out.println("Документ відправлений на модерацію.");
        context.setState(new ModerationState());
    }

    @Override
    public void render(Document context) {
        System.out.println("Відображення документа в режимі чернетки.");
    }
}

class ModerationState implements State {
    @Override
    public void publish(Document context) {
        System.out.println("Документ затверджений і опублікований.");
        context.setState(new PublishedState());
    }

    @Override
    public void render(Document context) {
        System.out.println("Відображення документа в режимі модерації.");
    }
}

class PublishedState implements State {
    @Override
    public void publish(Document context) {
        System.out.println("Документ вже опублікований. Нічого не потрібно робити.");
    }

    @Override
    public void render(Document context) {
        System.out.println("Відображення опублікованого документа.");
    }
}

public class StateExample {
    public static void main(String[] args) {
        Document document = new Document();

        document.render();
        document.publish();

        document.render();
        document.publish();

        document.render();
        document.publish();
    }
}

