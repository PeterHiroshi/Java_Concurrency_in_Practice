package peter8icestone.concurrency.chapter6;

import java.util.Optional;

public class ThreadInterrupt {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(50_000L);
            } catch (InterruptedException e) {
                System.out.println("receive interrupt signal");
                e.printStackTrace();
            }
        }, "t");
        t.start();
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of(t.isInterrupted()).ifPresent(System.out::println);
        t.interrupt();
        Optional.of(t.isInterrupted()).ifPresent(System.out::println);
    }
}
