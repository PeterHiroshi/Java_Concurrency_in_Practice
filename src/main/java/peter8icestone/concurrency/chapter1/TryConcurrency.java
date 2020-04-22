package peter8icestone.concurrency.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {
        // thread 1
        Thread t1 = new Thread(() -> {
           System.out.println(Thread.currentThread().getName());
           for (int i=0; i<10; i++) {
               System.out.println("task 1=>" + i);
               try {
                   // sleep 100 ms
                   Thread.sleep(100L);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }, "thread 1");
        t1.start();
        // main thread
        for (int i=0; i<1000; i++) {
            System.out.println("task 2=>" + i);
        }
    }
}
