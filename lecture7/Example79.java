package lecture7;

import java.util.Date;

public class Example79 {
    static int errorCode = 0;
    static int extraInformation = 0;

    public static void main(String[] args) {
        try {
            if (errorCode == 0)
                throw new CommError(1);
            else
                throw new ProtocolError(errorCode, extraInformation);
        } catch (ProtocolError e) {
            // handle ProtocolError by inspecting e appropriately
        } catch (CommError f) {
            // handle CommError by inspecting f appropriately
        }
    }
}

class CommError extends Exception {
    int errorKind;
    Date when;

    CommError(int a) {
        errorKind = a;
        when = new Date();
    }
}

class ProtocolError extends CommError {
    int errorSource;

    ProtocolError(int a, int b) {
        super(a);
        errorSource = b;
    }
}