package eventSystem;

public class Event {
	
	private String title, description, homeTeam, awayTeam, date;
	private int ticketPrice, seats;
	private boolean isVisible = true;
	
	public Event (String title, String description, String homeTeam, String awayTeam, int ticketPrice, int seats, String date, boolean isVisible) {
		
		this.awayTeam = awayTeam;
		this.date = date;
		this.description = description;
		this.homeTeam = homeTeam;
		this.setVisible(isVisible);
		this.seats = seats;
		this.ticketPrice = ticketPrice;
		this.title = title;
		
	}

	@Override
	public String toString() {
		return "Event [title=" + title + ", description=" + description + ", homeTeam=" + homeTeam + ", awayTeam="
				+ awayTeam + ", date=" + date + ", ticketPrice=" + ticketPrice + ", seats=" + seats + ", isVisible="
				+ isVisible() + "]";
	}

	public void setIsVisible(boolean b) {
		
		this.setVisible(b);
		
	}
	
	public String getTitle() {
		return title;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	

}
