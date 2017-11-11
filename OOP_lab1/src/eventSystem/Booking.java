package eventSystem;

public class Booking {
	
	private int bookingID;
	private Event event;
	private int seats;
	private Customer customer;
	private static int startVal = 100;
	

	
public Booking(Event event, int seats, Customer customer) {
		
		this.seats = seats;
		this.event = event;
		this.customer = customer;
		this.bookingID = startVal;
		
		
		startVal ++;
	}




@Override
public String toString() {
	return "Booking [bookingID=" + bookingID + ", event=" + event + ", seats=" + seats + ", customer=" + customer + "]";
}






	



}
