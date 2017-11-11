package lab2;

public class Book extends Product {
	
	private BookGenre genre;

	public Book(BookGenre genre, String title, int price) {
		super(title, price);
		
		this.genre = genre;
		
	}
	
	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return super.toString() + " genre = " + genre + "]";
	}


	

}
