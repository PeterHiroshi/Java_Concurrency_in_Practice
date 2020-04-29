package peter8icestone.concurrency.chapter6;

import java.util.Optional;

public class ThreadService {

    private Thread executeThread;

    private boolean finished = false;

    public void execute(Runnable task) {
        executeThread = new Thread(() -> {
            Thread runner = new Thread(task);
            runner.setDaemon(true);
            runner.start();
            try {
                runner.join();
                finished = true;
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }, "executeThread");
        executeThread.start();
    }

    public void shutdown(long millis) {
        long current = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - current >= millis) {
                Optional.of("timeout, task will be shutdown").ifPresent(System.out::println);
                executeThread.interrupt();
                break;
            }
            try {
                executeThread.sleep(1L);
            } catch (InterruptedException e) {
                Optional.of("execute thread is interrupted").ifPresent(System.out::println);
                break;
            }
        }
        finished = false;
    }
}
