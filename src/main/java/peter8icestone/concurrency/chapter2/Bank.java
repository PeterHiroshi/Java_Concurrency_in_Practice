package peter8icestone.concurrency.chapter2;

public class Bank {

    public static void main(String[] args) {
        TicketWindowRunnable ticketWindowRunnable = new TicketWindowRunnable();
        Thread t1 = new Thread(ticketWindowRunnable, "1");
        Thread t2 = new Thread(ticketWindowRunnable, "2");
        Thread t3 = new Thread(ticketWindowRunnable, "3");
        t1.start();
        t2.start();
        t3.start();
    }
}
