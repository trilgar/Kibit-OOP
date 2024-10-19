package lecture9.example4;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.LongStream;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class StreamParallel {

    public static void main(String[] args) {
        DoubleUnaryOperator fn = (x) -> sin(x) * sin(x) + cos(x) * cos(x);
        long n = 10_000_000L;
        double from = 0;
        double to = 10;
        double step = (to - from) / n;
        long mili = System.currentTimeMillis();

        double result = LongStream.range(0, n)
                .parallel()
                .mapToDouble(x -> x * step)
                .map(x -> fn.applyAsDouble(x) * step)
                .sum();
        System.out.println("Calculated integral: " + result);
        System.out.println("Time taken: " + (System.currentTimeMillis() - mili));
    }
}