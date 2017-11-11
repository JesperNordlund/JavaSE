package lab2;

public class Address {
	
	private String street;
	private int streetNum;
	private int postalCode;
	private String city;
	

	public Address(String street, int streetNum, int postalCode, String city) {
		
		this.street = street;
		this.streetNum = streetNum;
		this.postalCode = postalCode;
		this.city = city;
		
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(int streetNum) {
		this.streetNum = streetNum;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", streetNum=" + streetNum + ", postalCode=" + postalCode + ", city="
				+ city + "]";
	}

}
