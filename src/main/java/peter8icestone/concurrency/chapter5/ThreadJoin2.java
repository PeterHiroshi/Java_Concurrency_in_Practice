package peter8icestone.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            IntStream.range(0, 100).forEach(i ->
                System.out.println(Thread.currentThread().getName() + "=>" + i)
            );
        }, "t1");
        Thread t2 = new Thread(() -> {
            IntStream.range(0, 100).forEach(i ->
                    System.out.println(Thread.currentThread().getName() + "=>" + i)
            );
        }, "t2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of("All tasks finish done!").ifPresent(System.out::println);
        IntStream.range(0, 100).forEach(i ->
            System.out.println(Thread.currentThread().getName() + "=>" + i)
        );
    }
}
