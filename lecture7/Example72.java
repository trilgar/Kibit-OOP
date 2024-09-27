package lecture7;

public class Example72 {
}


class X {
    String m() {
        try {
            // some code
        } catch (TransmissionError t) {
            // do something to handle exception
            System.out.println(t.getMessage());
        }
    }
}