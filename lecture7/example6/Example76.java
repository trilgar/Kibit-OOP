package lecture7.example6;

import java.io.IOException;

public class Example76 {
    public static void main(String[] args) {
       try {
           send();
       } catch (ArithmeticException e) {
           System.out.println("Error");
       }
    }
    public static void send(){
        EMail email = new EMail();
        email.send("123");
    }
}

class EMail {
    void send(String address) {
        int errorCode = 0;
        try {
            makeHostConnection(emailHostOf(address));
            verifyUser(emailUserOf(address));
            while (!endofInputBuffer()) {
                String line = readInputBuffer();
                sendContent(line);
            }
            throw new ArithmeticException();
        } catch (SocketException | NoUserReply | WriteError exception) {
            exception.getCause();
            errorCode = 1;
        }
        System.out.println("End");
    }

    String emailUserOf(String address) throws NoUserReply {
        // code to extract user from email address
        return null;
    }

    void makeHostConnection(String host) throws SocketException {
        // code to make connection
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
}

class NoUserReply extends Exception {
}

class WriteError extends Exception {
}

class SocketException extends Exception {
}