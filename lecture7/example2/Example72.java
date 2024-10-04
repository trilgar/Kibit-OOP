package lecture7.example2;

public class Example72 {
}


class X {
    String m() {
        try {
            // some code
            throw new TransmissionError(1);
        } catch (TransmissionError t) {
            // do something to handle exception
            System.out.println(t.getMessage());
        }
        return "X";
    }
}

class TransmissionError extends Exception {
    int errorKind;

    TransmissionError() {
        errorKind = 0;
    }

    TransmissionError(int x) {
        errorKind = x;
    }

    @Override
    public String toString() {
        return ("Transmission Error: " + errorKind);
    }
}