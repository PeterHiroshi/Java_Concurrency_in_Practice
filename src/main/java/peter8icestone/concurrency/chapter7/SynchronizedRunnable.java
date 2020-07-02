package peter8icestone.concurrency.chapter7;

import java.util.Optional;

public class SynchronizedRunnable implements Runnable {

    private static final int MAX = 500;
    private int index = 1;

    // the monitor is this
    @Override
    public synchronized void run() {
        while (true) {
            if (index <= MAX) {
                try {
                    Thread.sleep(5L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Optional.of(Thread.currentThread() + ", number=" + index++)
                        .ifPresent(System.out::println);
            }
        }
    }
}
