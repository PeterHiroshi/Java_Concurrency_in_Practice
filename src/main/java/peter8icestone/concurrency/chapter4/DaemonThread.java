package peter8icestone.concurrency.chapter4;

public class DaemonThread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running");
            try {
                Thread.sleep(20_000L); //JDK1.7 +
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " done");
        });
        t.setDaemon(true);
        // runnable ->running ->blocked ->terminated
        t.start();
        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
