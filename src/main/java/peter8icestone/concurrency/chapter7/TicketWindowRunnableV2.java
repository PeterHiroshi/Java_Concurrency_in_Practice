package peter8icestone.concurrency.chapter7;

import java.util.Optional;

public class TicketWindowRunnableV2 implements Runnable {

    private final static int MAX = 500;

    private int index = 1;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index <= MAX) {
                    try {
                        Thread.sleep(5L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Optional.of(Thread.currentThread() + ", number = " + (index++))
                             .ifPresent(System.out::println);
                }
            }
        }
    }
}
