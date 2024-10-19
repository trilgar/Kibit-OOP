package lecture9.example5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.DoubleUnaryOperator;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DoubleUnaryOperator fn = (x) -> sin(x) * sin(x) + cos(x) * cos(x);
        long n = 10_000_000L;
        double from = 0;
        double to = 10;
        double step = (to - from) / n;
        long mili = System.currentTimeMillis();

        int threads = 4; // Кількість потоків для використання

        ExecutorService executorService = Executors.newFixedThreadPool(threads);
        List<CompletableFuture<Double>> futures = new ArrayList<>();

        double iFrom = from;
        double iPart = (to - from) / threads;

        for (int i = 0; i < threads; i++) {
            double start = iFrom;
            iFrom += iPart;
            double end = iFrom;

            final double taskStart = start;
            final double taskEnd = end;

            CompletableFuture<Double> future = CompletableFuture.supplyAsync(() -> {
                double result = 0;
                for (double x = taskStart; x < taskEnd; x += step) {
                    result += fn.applyAsDouble(x) * step;
                }
                return result;
            }, executorService);

            futures.add(future);
        }

        // Комбінуємо результати
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        CompletableFuture<Double> totalFuture = allFutures
                .thenApply(v ->
                        futures.stream()
                                .map(CompletableFuture::join)
                                .reduce(0.0, Double::sum));


        Double result = totalFuture.get();

        executorService.shutdown();

        System.out.println("Calculated integral: " + result);
        System.out.println("Time taken: " + (System.currentTimeMillis() - mili) + " ms");
    }
}

