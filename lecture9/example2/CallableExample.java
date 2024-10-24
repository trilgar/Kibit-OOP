package lecture9.example2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.DoubleUnaryOperator;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CallableExample {
    public static void main(String[] args) throws Exception {

        DoubleUnaryOperator fn = (x)->sin(x)*sin(x) + cos(x)*cos(x);
        //DoubleUnaryOperator fn = (x) -> 1;
        long n = 10_000_000L;
        double from = 0;
        double to = 10;
        double step = (to - from) / n;

        int threads = 6;


        long mili = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        Future<Double>[] results = new Future[threads];

        double iFrom = from;
        double iPart = (to - from) / threads;

        for (int i = 0; i < threads; i++) {
            MyIntegrator mi = new MyIntegrator(fn, iFrom, iFrom += iPart, step);
            results[i] = executor.submit(mi);
        }
        executor.shutdown();

        double totalResult = 0;
        for (Future<Double> result : results) {
            totalResult += result.get();
        }

        System.out.println("Calculated integral: " + totalResult);
        System.out.println("Time taken: " + (System.currentTimeMillis() - mili));

    }
}

class MyIntegrator implements Callable<Double> {

    DoubleUnaryOperator fn;
    double from; // inclusive
    double to; // exclusive
    double step;

    public MyIntegrator(DoubleUnaryOperator fn, double from, double to, double step) {
        this.fn = fn;
        this.from = from;
        this.to = to;
        this.step = step;
    }

    @Override
    public Double call() {
        double result = 0;
        for (double x = from; x < to; x += step) {
            result += fn.applyAsDouble(x) * step;
        }
        return result;
    }

}
