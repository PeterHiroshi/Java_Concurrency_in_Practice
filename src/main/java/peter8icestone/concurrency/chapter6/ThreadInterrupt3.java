package peter8icestone.concurrency.chapter6;

import java.util.Optional;

public class ThreadInterrupt3 {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread t_interrupt = new Thread(() -> {
            try {
                Thread.sleep(100L);
                mainThread.interrupt();
                Optional.of("interrupt t").ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t_stop");
        t_interrupt.start();
        Thread t = new Thread(() -> {
            while (true) {

            }
        }, "t");
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(t.isInterrupted());
        }
        System.out.println("finish done");
    }
}
