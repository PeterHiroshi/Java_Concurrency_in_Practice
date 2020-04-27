package peter8icestone.concurrency.chapter5;

public class ThreadJoin4 {

    public static void main(String[] args) {
        long startTimeStamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10_000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 5_000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 15_000L));
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTimeStamp = System.currentTimeMillis();
        System.out.printf("capture is done, startTimeStamp=%s, endTimeStamp=%s\n", startTimeStamp, endTimeStamp);
    }
}

class CaptureRunnable implements Runnable {

    private String machineName;
    private long spendTime;

    CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.printf("%s capture completed and successfully at [%s]\n",
                    machineName, System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
