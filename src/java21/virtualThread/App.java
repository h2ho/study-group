package java21.virtualThread;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.stream.IntStream;
import java.lang.Thread.Builder;

public class App {

    public static void main(String[] args) {

        // try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
        // IntStream.range(0, 10_000).forEach(i -> {
        // executor.submit(() -> {
        // Thread.sleep(Duration.ofSeconds(1));
        // return i;
        // });
        // });
        // }

        Runnable printThread = () -> System.out.println(Thread.currentThread());

        ThreadFactory virtualThreadFactory = Thread.ofVirtual().factory();
        ThreadFactory kernelThreadFactory = Thread.ofPlatform().factory();

        Thread virtualThread = virtualThreadFactory.newThread(printThread);
        Thread kernelThread = kernelThreadFactory.newThread(printThread);

        virtualThread.start();
        kernelThread.start();

        System.out.println("complete");

        // Executors.newCachedThreadPool()
    }
}
