package peter8icestone.concurrency.chapter6;

import java.util.Optional;

public class ThreadCloseGraceful {

    private static class Worker extends Thread {

        private volatile boolean started = true;

        @Override
        public void run() {
            Optional.of(Thread.currentThread().getName() + " is running")
                    .ifPresent(System.out::println);
            while (started) {
                // do nothing but wait
            }
        }

        void shutDown() {
            this.started = false;
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
        ((Worker) worker).shutDown();
    }

}
