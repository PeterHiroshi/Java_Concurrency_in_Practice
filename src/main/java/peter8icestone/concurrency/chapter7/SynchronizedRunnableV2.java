package peter8icestone.concurrency.chapter7;

import java.util.Optional;

public class SynchronizedRunnableV2 implements Runnable {

    private static final int MAX = 500;
    private int index = 1;

    @Override
    public void run() {
        while (true) {
            if (!sellTicket()) {
                break;
            }
        }
    }

    // monitor is this
    private synchronized boolean sellTicket() {
        if (index > MAX) {
            return false;
        }
        try {
            Thread.sleep(5L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of(Thread.currentThread() + ", number=" + index++)
                .ifPresent(System.out::println);
        return true;
    }
}
