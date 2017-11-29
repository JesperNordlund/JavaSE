import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalDAO {
	
	private PersonalConnectionFactory pcFactory;
	
	public PersonalDAO(PersonalConnectionFactory pcFactory) {
		
		this.pcFactory = pcFactory;
	}

	public Personal getById(int id) {
		
		int personalId = 0;
		String namn = null;
		String befattning = null;
		int avdelningId = 0;
		
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection connection = null;
		
		try {
		
		connection = pcFactory.getConnection();
		
		stmt = connection.prepareStatement(
				"SELECT * " +
				"FROM personal p " +
				"WHERE p.personalid = 7313;");
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			
			personalId = rs.getInt("personalid");
			namn = rs.getString("namn");
			befattning = rs.getString("befattning");
			avdelningId = rs.getInt("avdelningId");
		}
		
		Personal personal = new Personal(personalId, namn, befattning, avdelningId);
		return personal;
		
		}catch(SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
        	System.out.println("SQLState: " + ex.getSQLState());
        	System.out.println("VendorError: " + ex.getErrorCode());
        }finally
			
			 {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		return null;
		
		
	}
	
	public void deleteById(int id) {
		
	}
	
	public void updateNameById(int id, String newName) {
		
	}
	
	public void addById(Personal p) {
		
	}
}
