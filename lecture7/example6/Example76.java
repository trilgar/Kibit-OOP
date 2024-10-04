package lecture7.example6;

public class Example76 {
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
        } catch (SocketException s) {
            errorCode = 1;
        } catch (NoUserReply n) {
            errorCode = 2;
        } catch (WriteError w) {
            errorCode = 3;
        }
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