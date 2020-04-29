package peter8icestone.concurrency.chapter6;

import java.util.Optional;

public class ThreadInterrupt2 {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                synchronized (MONITOR) {
                    try {
                        MONITOR.wait(100L);
                    } catch (InterruptedException e) {
                        System.out.println("receive interrupt signal");
                        e.printStackTrace();
                        System.out.println(">>" + Thread.interrupted());
                    }
                }
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
