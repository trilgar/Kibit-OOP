package lecture7;

public class Example77 {
}

class EMail {
    int errorCode = 0;

    void makeHostConnection(String host) {
        openSocket(host);
        if (!IOerror()) {
            checkResponse();
            giveGreetings();
        }
    }

    void giveGreetings() {
        if (IOerror())
            errorCode = 9;
        else
            checkResponse();
    }

    void verifyUser(String user) {
        if (IOerror())
            errorCode = 9;
        else
            checkResponse();
    }

    void errorMessage(String message) {
        // code to display error message
    }

    void sendContent(String content) {
        // code to send content
    }

    boolean endofInputBuffer() {
        // code to check end of input buffer
    }

    String readInputBuffer() {
        // code to read input buffer
        return null;
    }

    String emailHostOf(String address) {
        // code to extract host from email address
        return null;
    }

    String emailUserOf(String address) {
        // code to extract user from email address
        return null;
    }

    void openSocket(String host) {
        // code to open socket
    }

    boolean IOerror() {
        // code to check IO error
        return false;
    }

    void checkResponse() {
        // code to check response
    }
}
