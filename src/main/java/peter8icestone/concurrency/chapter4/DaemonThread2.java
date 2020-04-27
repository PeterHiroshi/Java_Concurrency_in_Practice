package peter8icestone.concurrency.chapter4;

public class DaemonThread2 {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            Thread innerThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println("do something for health check.");
                        Thread.sleep(500L);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "innerThread");
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(1_000L);
                System.out.println(Thread.currentThread().getName() + " finish done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t");
        t.start();
    }
}
