package lecture13.mediator;

// Client code
public class MediatorExample {
    public static void main(String[] args) {
        AuthenticationDialog dialog = new AuthenticationDialog();

        // Simulate user interaction
        dialog.loginOrRegisterChkBx.check();  // Switch to Register mode
        dialog.okBtn.click();                 // Attempt to register
        dialog.loginOrRegisterChkBx.check();  // Switch to Login mode
        dialog.okBtn.click();                 // Attempt to log in
    }
}

// Mediator interface
interface Mediator {
    void notify(Component sender, String event);
}

// Concrete Mediator class
class AuthenticationDialog implements Mediator {
    public Checkbox loginOrRegisterChkBx;
    public Textbox loginUsername;
    public Textbox loginPassword;
    public Textbox registrationUsername;
    public Textbox registrationPassword;
    public Textbox registrationEmail;
    public Button okBtn;
    public Button cancelBtn;

    public AuthenticationDialog() {
        this.loginOrRegisterChkBx = new Checkbox(this);
        this.loginUsername = new Textbox(this);
        this.loginPassword = new Textbox(this);
        this.registrationUsername = new Textbox(this);
        this.registrationPassword = new Textbox(this);
        this.registrationEmail = new Textbox(this);
        this.okBtn = new Button(this);
        this.cancelBtn = new Button(this);
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender == loginOrRegisterChkBx && event.equals("check")) {
            if (loginOrRegisterChkBx.isChecked()) {
                System.out.println("Log in");
                // Show login form components
                // Hide registration form components
            } else {
                System.out.println("Register");
                // Show registration form components
                // Hide login form components
            }
        }

        if (sender == okBtn && event.equals("click")) {
            if (loginOrRegisterChkBx.isChecked()) {
                // Attempt to find user with login form data
                System.out.println("Attempting to log in...");
                // If not found, show error message above login form
            } else {
                // Create user account with registration form data
                System.out.println("Creating user account...");
                // Log in this user
            }
        }
    }
}

// Base Component class
abstract class Component {
    protected Mediator dialog;

    public Component(Mediator dialog) {
        this.dialog = dialog;
    }
}

// Concrete Component classes
class Button extends Component {
    public Button(Mediator dialog) {
        super(dialog);
    }

    public void click() {
        dialog.notify(this, "click");
    }
}

class Textbox extends Component {
    public Textbox(Mediator dialog) {
        super(dialog);
    }

    public void input(String text) {
        System.out.println("Textbox input: " + text);
        dialog.notify(this, "input");
    }
}

class Checkbox extends Component {
    private boolean checked;

    public Checkbox(Mediator dialog) {
        super(dialog);
    }

    public void check() {
        checked = !checked;
        dialog.notify(this, "check");
    }

    public boolean isChecked() {
        return checked;
    }
}


