
public class Personal {
	
	private int personalId;
	private String namn;
	private String befattning;
	private int avdelningId;
	
	public Personal(int personalId, String namn, String befattning, int avdelningId) {
		
		this.personalId = personalId;
		this.namn = namn;
		this.befattning = befattning;
		this.avdelningId = avdelningId;
	}

	@Override
	public String toString() {
		return "Personal [personalId=" + personalId + ", namn=" + namn + ", befattning=" + befattning + ", avdelningId="
				+ avdelningId + "]";
	}

	public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getBefattning() {
		return befattning;
	}

	public void setBefattning(String befattning) {
		this.befattning = befattning;
	}

	public int getAvdelningId() {
		return avdelningId;
	}

	public void setAvdelningId(int avdelningId) {
		this.avdelningId = avdelningId;
	}

}
