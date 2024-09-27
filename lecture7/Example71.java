package lecture7;

public class Example71 {

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