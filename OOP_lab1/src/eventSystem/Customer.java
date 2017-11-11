package eventSystem;

public class Customer {
	
	
	private String customerName;
	private int customerID;
	static int startVal = 1;
	
	
public Customer(String customerName){
		
	this.customerName = customerName;
	this.customerID = startVal;
	
	startVal ++;
	
	}
	
	public String getName() {
		return customerName;
		
	}

	


	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", customerID=" + customerID + "]";
	}

	public int getID() {
		
		return customerID;
	}


	

}
