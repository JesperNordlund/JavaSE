package lab2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		
		Address address = new Address("Södra Slottsgatan", 16, 80253, "Gävle");
		
		Customer customer = new Customer(533068, "Jesper", "Nordlund", address);
		
		Book product1 = new Book(BookGenre.FANTASY, "Age of dragons", 349);
		
		Book product2 = new Book(BookGenre.CRIME, "The cabin by the lake", 289);
		
		Book product3 = new Book(BookGenre.ROMANCE, "Letters of passion", 249);
		
		List<Product> orderedProducts = new ArrayList<Product>();
		
		orderedProducts.add(product1);
		orderedProducts.add(product2);
		orderedProducts.add(product3);
		
		
		IOrder order = new Order(788345, orderedProducts, customer);
		
		System.out.println(order + "Total price:\n" + order.getTotalPrice(orderedProducts) + " SEK");
		

	}

}
