package peter8icestone.concurrency.chapter2;

public class TicketWindowRunnable implements Runnable {

    private static final int MAX = 50;

    private int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println("window: " + Thread.currentThread().getName() + ", ticket number: " + index++);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
