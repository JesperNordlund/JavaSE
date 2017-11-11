package eventSystem;

public class TestRun {

	public TestRun() {
	}
	
	public void start() {



		//Creating customer registry

		Registry<Customer> customerList = new Registry<Customer>();

		//Populating list of customers

		System.out.println("Adding customers to the system:");

		Customer customer1 = new Customer("Ahmed");
		Customer customer2 = new Customer("Jesper");
		Customer customer3 = new Customer("Tomas");

		customerList.getRegList().add(customer1);
		customerList.getRegList().add(customer2);
		customerList.getRegList().add(customer3);

		//Printing list of customers

		for (Customer customer : customerList.getRegList()) {
			System.out.println(customer);
		}

		//Creating event registry

		Registry<Event> eventList = new Registry<Event>();

		//Populating list of events

		System.out.println("\nAdmin creates three events:");

		Event event1 = new Event("Semifinal1", "First semifinal in the tournament", "Hudiksvall", "Iggesund", 249, 1500, "4/10", true);
		Event event2 = new Event("Semifinal2", "Second semifinal in the tournament", "Delsbo", "Ljusdal", 249, 1500, "9/10", true);
		Event event3 = new Event("Final", "Final game of the tournament", "Hudiksvall", "Ljusdal", 279, 2000, "13/10", false);

		eventList.getRegList().add(event1);
		eventList.getRegList().add(event2);
		eventList.getRegList().add(event3);

		//Printing list of events

		for (Event event : eventList.getRegList()) {
			System.out.println(event);
		}

		System.out.println("\nAdmin deletes Semifinal2. Events remaining:");

		//Removing object from regList and removing all references to event2. Garbage collector will delete it.

		eventList.getRegList().remove(event2);
		event2 = null;

		for (Event event : eventList.getRegList()) {
			System.out.println(event.getTitle());
		}

		//Showing events that are visible to customers

		for (Event event : eventList.getRegList()) {

			if(event.isVisible()) {
				System.out.println("\nEvents visible to customers:\n" + event.getTitle());
			}
		}

		//Admin changes visibility for the final game(event3)

		eventList.getRegList().get(1).setIsVisible(true);

		System.out.println("\nAdmin makes the final visible:\n" + eventList.getRegList().get(1).isVisible());

		System.out.println("\nEvents visible to customers:");

		for (Event event : eventList.getRegList()) {

			if(event.isVisible()) {
				System.out.println(event.getTitle());
			}
		}

		//Creating booking registry

		Registry<Booking> bookingList = new Registry<Booking>();

		//Creating bookings and printing

		Booking booking1 = new Booking(eventList.getRegList().get(0), 3, customerList.getRegList().get(0));
		Booking booking2 = new Booking(eventList.getRegList().get(1), 2, customerList.getRegList().get(2));

		bookingList.getRegList().add(booking1);
		bookingList.getRegList().add(booking2);

		System.out.println("\nBookings:");

		for (Booking booking : bookingList.getRegList()) {

			System.out.println(booking);
		}
	}
}

