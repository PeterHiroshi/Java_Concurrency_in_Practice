package peter8icestone.concurrency.chapter3;

public class CreateThread {

    public static void main(String[] args) {
        // constructor: Thread()
        Thread t1 = new Thread();
        System.out.println("t1:" + t1.getName());
        // constructor Thread() & override run()
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("override run()");
            }
        };
        t2.start();
        System.out.println("t2:" + t2.getName());
        // constructor: Thread(String name)
        Thread t3 = new Thread("thread2");
        System.out.println("t3:" + t3.getName());
        // constructor: Thread(Runnable target)
        Thread t4 = new Thread(() -> {
            System.out.println("runnable target");
        });
        t4.start();
        System.out.println("t4:" + t4.getName());
        // constructor: Thread(Runnable target, String name)
        Thread t5 = new Thread(() -> {
            System.out.println("runnable target");
            System.out.println("t5:" + Thread.currentThread().getName());
        }, "RunnableThread");
        t5.start();
    }
}
