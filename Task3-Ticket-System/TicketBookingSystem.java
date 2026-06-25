import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

class TicketCounter {
    private int tickets = 10;
    private ReentrantLock lock = new ReentrantLock();

    public void bookTicket(String user) {
        lock.lock();  

        try {
            if (tickets > 0) {
                System.out.println(user + " booked ticket. Remaining: " + (--tickets));
            } else {
                System.out.println(user + " failed - Sold Out!");
            }
        } finally {
            lock.unlock();
        }
    }
}

class UserTask implements Runnable {
    private TicketCounter counter;
    private String userName;

    public UserTask(TicketCounter counter, String userName) {
        this.counter = counter;
        this.userName = userName;
    }

    @Override
    public void run() {
        counter.bookTicket(userName);
    }
}

public class TicketBookingSystem {
    public static void main(String[] args) {

        TicketCounter counter = new TicketCounter();

        ExecutorService executor = Executors.newFixedThreadPool(20);

        
        for (int i = 1; i <= 100; i++) {
            executor.execute(new UserTask(counter, "User-" + i));
        }

        executor.shutdown();
    }
}
