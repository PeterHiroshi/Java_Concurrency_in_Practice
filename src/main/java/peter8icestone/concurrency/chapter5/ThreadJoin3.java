package peter8icestone.concurrency.chapter5;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin3 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Optional.of(Thread.currentThread().getName() + " is running")
                    .ifPresent(System.out::println);
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Optional.of(Thread.currentThread().getName() + " is done")
                    .ifPresent(System.out::println);
        }, "t");
        t.start();
        try {
            t.join(100, 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of("All tasks finish done!").ifPresent(System.out::println);
        IntStream.range(0, 100).forEach(i ->
                System.out.println(Thread.currentThread().getName() + "=>" + i)
        );
//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
