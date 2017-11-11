package lab2;

public class Customer {
	
	private int customerNum;
	private String firstName, lastName;
	private Address address;
	
	public Customer(int customerNum, String firstName, String lastName, Address address){
		
		this.customerNum = customerNum;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		
	}

	public int getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "[customerNum=" + customerNum + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + "]";
	}

}
