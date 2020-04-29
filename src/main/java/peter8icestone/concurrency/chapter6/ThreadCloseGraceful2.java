package peter8icestone.concurrency.chapter6;

public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is running...");
            while (true) {
//                try {
//                    sleep(1L);
//                } catch (InterruptedException e) {
//                    break;
//                }
                if (isInterrupted()) {
                    break;
                }
            }
            // do something after loop
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }

    public static void main(String[] args) {
        Thread worker = new Worker();
        worker.start();
        try {
            Thread.sleep(1_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.interrupt();
    }
}
