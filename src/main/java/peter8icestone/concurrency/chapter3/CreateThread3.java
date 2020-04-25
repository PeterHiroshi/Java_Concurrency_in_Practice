package peter8icestone.concurrency.chapter3;

public class CreateThread3 {

    private static int counter = 1;

    public static void main(String[] args) {
        // create a JVM stack
        try {
            add(0);
        } catch (Error e) {
            System.out.println(counter);
            e.printStackTrace();
        }
    }

    private static void add(int i) {
        counter ++;
        add(i ++);
    }

}
