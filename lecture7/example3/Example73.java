package lecture7.example3;

public class Example73 {
}

class X {
    String m() {
        boolean exceptionalCase = true;
        try {
            if(exceptionalCase) {
                throw new TransmissionError(1);
            }
            // some code
        } catch (TransmissionError t) {
            // do something to handle exception
            System.out.println(t.getMessage());
        }
        return "m() method";
    }
}

class TransmissionError extends Exception {
    int errorKind;

    TransmissionError(int x) {
        errorKind = x;
    }

    @Override
    public String toString() {
        return ("Transmission Error: " + errorKind);
    }
}