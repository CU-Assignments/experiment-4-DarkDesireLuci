//HArd Exp4 
import java.util.*;

class TicketBookingSystem {
    private final Set<Integer> bookedSeats = new HashSet<>();
    
    synchronized boolean bookSeat(int seatNumber) {
        if (bookedSeats.contains(seatNumber)) {
            return false;
        }
        bookedSeats.add(seatNumber);
        return true;
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;

    BookingThread(TicketBookingSystem system, int seatNumber, int priority) {
        this.system = system;
        this.seatNumber = seatNumber;
        setPriority(priority);
    }

    public void run() {
        if (system.bookSeat(seatNumber)) {
            System.out.println(Thread.currentThread().getName() + " successfully booked seat " + seatNumber);
        } else {
            System.out.println(Thread.currentThread().getName() + " failed to book seat " + seatNumber + " (already booked)");
        }
    }
}

public class TicketBookingMain {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        Thread vip1 = new BookingThread(system, 1, Thread.MAX_PRIORITY);
        Thread vip2 = new BookingThread(system, 1, Thread.MAX_PRIORITY);
        Thread normal1 = new BookingThread(system, 2, Thread.NORM_PRIORITY);
        Thread normal2 = new BookingThread(system, 2, Thread.NORM_PRIORITY);
        
        vip1.start();
        vip2.start();
        normal1.start();
        normal2.start();
    }
}
