package peter8icestone.concurrency.chapter7;

public class BankV2 {

    public static void main(String[] args) {
        TicketWindowRunnableV2 ticketWindowRunnableV2 = new TicketWindowRunnableV2();
        Thread t1 = new Thread(ticketWindowRunnableV2, "t1");
        Thread t2 = new Thread(ticketWindowRunnableV2, "t2");
        Thread t3 = new Thread(ticketWindowRunnableV2, "t3");
        t1.start();
        t2.start();
        t3.start();
    }
}
