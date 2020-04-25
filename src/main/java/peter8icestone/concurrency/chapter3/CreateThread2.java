package peter8icestone.concurrency.chapter3;

import java.util.Arrays;

public class CreateThread2 {

    public static void main(String[] args) {
        //  create a JVM stack
        Thread t1 = new Thread();
        System.out.println(t1.getThreadGroup().getName());
        Thread t2 = new Thread(() -> {
            ThreadGroup currentThreadGroup = Thread.currentThread().getThreadGroup();
            if (currentThreadGroup != null) {
                System.out.println(currentThreadGroup.getName());
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.activeCount());
        Thread[] list = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(list);
        Arrays.asList(list).forEach(System.out::println);
    }
}
