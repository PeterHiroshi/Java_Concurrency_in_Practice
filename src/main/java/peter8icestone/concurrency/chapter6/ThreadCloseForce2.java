package peter8icestone.concurrency.chapter6;

public class ThreadCloseForce2 {

    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            try {
                Thread.sleep(2_000L);
            } catch (InterruptedException e) {
//                    e.printStackTrace();
            }
        });
        threadService.shutdown(6_000L);
        long end = System.currentTimeMillis();
        System.out.println("costs: " + (end - start) + "ms");
    }
}
