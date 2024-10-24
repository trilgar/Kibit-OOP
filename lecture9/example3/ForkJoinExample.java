package lecture9.example3;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.DoubleUnaryOperator;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class ForkJoinExample {
    public static void main(String[] args) {
        DoubleUnaryOperator fn = (x)->sin(x)*sin(x) + cos(x)*cos(x);
        long n = 10_000_000L;
        double from = 0;
        double to = 10;
        double step = (to - from) / n;
        long mili = System.currentTimeMillis();

        MyIntegrator2 mi2 = new MyIntegrator2(fn, from, to, step);

        int threads = 6;
        ForkJoinPool pool = new ForkJoinPool(threads);
        Double result = pool.invoke(mi2);

        System.out.println("Calculated integral: " + result);
        System.out.println("Time taken: " + (System.currentTimeMillis() - mili));
    }
}
class MyIntegrator2 extends RecursiveTask<Double> {

    static final double THRESHOLD = 100000;
    DoubleUnaryOperator fn;
    double from; // inclusive
    double to; // exclusive
    double step;

    public MyIntegrator2(DoubleUnaryOperator fn, double from, double to, double step) {
        this.fn = fn;
        this.from = from;
        this.to = to;
        this.step = step;
    }

    @Override
    public Double compute() {
        double result = 0;
        double quantityOfSteps = (to - from) / step;

        if (quantityOfSteps < THRESHOLD) {
            // if the quantity of steps is less than the threshold, we calculate the integral
            for (double x = from; x < to; x += step) {
                result += fn.applyAsDouble(x) * step;
            }
        } else {
            // if the quantity of steps is greater than the threshold, we split the interval in two
            double mid = (from + to) / 2;
            MyIntegrator2 miLeft = new MyIntegrator2(fn, from, mid, step);
            MyIntegrator2 miRight = new MyIntegrator2(fn, mid, to, step);
            miLeft.fork();
            Double rightResult = miRight.compute();
            Double leftResult = miLeft.join();
            result = rightResult + leftResult;
        }
        return result;
    }

}