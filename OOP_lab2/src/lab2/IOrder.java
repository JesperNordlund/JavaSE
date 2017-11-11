package lab2;

import java.util.List;

public interface IOrder {
	
	List<Product> getProducts();
	double getTotalPrice(List<Product> orderedProducts);

}
