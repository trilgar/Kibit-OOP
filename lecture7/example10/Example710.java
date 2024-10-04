package lecture7.example10;

import java.util.Date;

public class Example710 {
    static int errorCode = 0;
    static int extraInformation = 0;

    public static void main(String[] args) {
        try {
            if (errorCode == 0)
                throw new CommError(1);
            else
                throw new ProtocolError(errorCode, extraInformation);
        } catch (ProtocolError e) {
            // Обробка ProtocolError
            try {
                System.out.println("Handling ProtocolError");
                // Імітація додаткової помилки при обробці ProtocolError
                if (e.errorSource == 0) {
                    throw new Exception("Nested exception in ProtocolError handler");
                }
            } catch (Exception nested) {
                System.out.println("Nested Exception Caught in ProtocolError handler: " + nested.getMessage());
            }
        } catch (CommError f) {
            // Обробка CommError
            try {
                System.out.println("Handling CommError");
                // Імітація додаткової помилки при обробці CommError
                if (f.errorKind == 1) {
                    throw new Exception("Nested exception in CommError handler");
                }
            } catch (Exception nested) {
                System.out.println("Nested Exception Caught in CommError handler: " + nested.getMessage());
            }
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
