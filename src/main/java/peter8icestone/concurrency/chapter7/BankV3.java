package peter8icestone.concurrency.chapter7;

public class BankV3 {

    private static void case1() {
        SynchronizedRunnable synchronizedRunnable = new SynchronizedRunnable();
        Thread t1 = new Thread(synchronizedRunnable, "t1");
        Thread t2 = new Thread(synchronizedRunnable, "t2");
        Thread t3 = new Thread(synchronizedRunnable, "t3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void case2() {
        SynchronizedRunnableV2 synchronizedRunnable = new SynchronizedRunnableV2();
        Thread t1 = new Thread(synchronizedRunnable, "t1");
        Thread t2 = new Thread(synchronizedRunnable, "t2");
        Thread t3 = new Thread(synchronizedRunnable, "t3");
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
//        case1();
        case2();
    }

}
