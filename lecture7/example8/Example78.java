package lecture7.example8;

import java.io.IOException;

public class Example78 {
}

class EMail {
    int errorCode = 0;

    void send(String address) {
        try {
            errorCode = 0;
            makeHostConnection(emailHostOf(address));
            verifyUser(emailUserOf(address));
        } catch (IOException x) {
            // network error detected
        }
    }

    void makeHostConnection(String host) throws SocketException {
        openSocket(host);
        checkResponse();
    }

    void giveGreetings() {
        if (IOerror())
            errorCode = 9;
        else
            checkResponse();
    }

    void openSocket(String host) throws SocketException {
        // code to open socket
    }

    boolean IOerror() {
        // code to check IO error
        return false;
    }

    void checkResponse() {
        // code to check response
    }

    String emailUserOf(String address) throws NoUserReply {
        // code to extract user from email address
        return null;
    }

    void verifyUser(String user) {
        // code to verify user
    }

    void errorMessage(String message) {
        // code to display error message
    }

    void sendContent(String content) {
        // code to send content
    }

    boolean endofInputBuffer() {
        // code to check end of input buffer
        return false;
    }

    String readInputBuffer() throws WriteError {
        // code to read input buffer
        return null;
    }

    String emailHostOf(String address) {
        // code to extract host from email address
        return null;
    }

    static class NoUserReply extends IOException {
    }

    static class WriteError extends IOException {
    }

    static class SocketException extends IOException {
    }
}

