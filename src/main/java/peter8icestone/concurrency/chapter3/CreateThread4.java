package peter8icestone.concurrency.chapter3;

public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            try {
//                add(0);
//            } catch (Error e) {
//                System.out.println(counter);
//            }
//        });
//        t1.start();
        Thread t2 = new Thread(null, () -> {
            try {
                add(0);
            } catch (Error e) {
                System.out.println(counter);
            }
        }, "t2", 1 << 24);
        t2.start();
    }

    private static void add(int i) {
        counter ++;
        add(i ++);
    }

}
