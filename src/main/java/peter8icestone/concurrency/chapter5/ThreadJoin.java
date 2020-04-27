package peter8icestone.concurrency.chapter5;

import java.util.stream.IntStream;

public class ThreadJoin {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            IntStream.range(0, 100).forEach(i -> {
                System.out.println(Thread.currentThread().getName() + "=>" + i);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }, "t");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IntStream.range(0, 100).forEach(i -> {
            System.out.println(Thread.currentThread().getName() + "=>" + i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
