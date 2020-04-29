package peter8icestone.concurrency.chapter6;

public class ThreadCloseForce {

    public static void main(String[] args) {
        ThreadService threadService = new ThreadService();
        long start = System.currentTimeMillis();
        threadService.execute(() -> {
            while (true) {
                // load a very heavy resource
            }
        });
        threadService.shutdown(3_000L);
        long end = System.currentTimeMillis();
        System.out.println("costs: " + (end - start) + "ms");
    }
}
