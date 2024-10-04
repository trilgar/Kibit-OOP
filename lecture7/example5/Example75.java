package lecture7.example5;

public class Example75 {
}

class EMail {

    void send(String address) {
        int errorCode = 0;
        boolean connectionError = true;
        boolean noUserReply = true;
        boolean networkError = true;
        makeHostConnection(emailHostOf(address));
        if (connectionError) {
            errorCode = 1;
        } else {
            verifyUser(emailUserOf(address));
            if (noUserReply) {
                errorMessage("user is not valid");
                errorCode = 2;
            } else{
                while ((!endofInputBuffer()) && errorCode != -1) {
                    String line = readInputBuffer();
                    sendContent(line);
                }
                if (networkError) {
                    errorCode = 3;
                }
            }
        }
    }

    String emailUserOf(String address) {
        // code to extract user from email address
        return null;
    }
    void makeHostConnection(String host) {
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

    String readInputBuffer() {
        // code to read input buffer
        return null;
    }

    String emailHostOf(String address) {
        // code to extract host from email address
        return null;
    }
}