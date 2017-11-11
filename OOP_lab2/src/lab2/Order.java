package lab2;

import java.util.List;

public class Order implements IOrder {

	private int orderNum;
	private Customer customer;
	private List<Product> orderedProducts;


	public Order(int orderNum, List<Product> orderedProducts, Customer customer) {
		
		this.orderNum = orderNum;
		this.customer = customer;
		this.orderedProducts = orderedProducts;

	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	@Override
	public  double getTotalPrice(List<Product> orderedProducts) {

		int totalPrice = orderedProducts.stream().filter(o -> o.getPrice() > 10).mapToInt(o -> o.getPrice()).sum();

		return totalPrice;
	}

	@Override
	public List<Product> getProducts() {

		return orderedProducts;
	}




	@Override
	public String toString() {
		return "Order:\n" + orderNum + "\n\nCustomer: \n" + customer + "\n\nOrdered products: \n" + orderedProducts +"\n\n";
	}


}
