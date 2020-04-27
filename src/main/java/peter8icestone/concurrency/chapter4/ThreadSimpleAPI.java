package peter8icestone.concurrency.chapter4;

import java.util.Optional;

public class ThreadSimpleAPI {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Optional.of("new t1").ifPresent(System.out::println);
        }, "t1");
        t1.start();
        Optional.of(t1.getId()).ifPresent(System.out::println);
        Optional.of(t1.getName()).ifPresent(System.out::println);
        Optional.of(t1.getPriority()).ifPresent(System.out::println);
    }
}
