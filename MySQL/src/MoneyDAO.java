import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;;

public class MoneyDAO {

	private BankConnectionFactory bankfactory = null;

	public MoneyDAO(BankConnectionFactory bankfactory) {

		this.bankfactory = bankfactory;

	}

	public void transfer(int amount, int fromAccount, int toAccount) {

			PreparedStatement stmt1 = null;
			PreparedStatement stmt2 = null;
			PreparedStatement stmt3 = null;
			
			
			ResultSet rs = null;
			
			int balance = 0;
			
			Connection connection = null;
			try {
				
				connection = bankfactory.getConnection();
				
				connection.setAutoCommit(false);
			
				stmt1 = connection.prepareStatement(
						"SELECT amount from accounts a where a.number = 1;");
				
				rs = stmt1.executeQuery();
				
				while(rs.next()) {
				balance = rs.getInt("amount");
				}
				
				if(balance >= amount ) {

			
				stmt2 = connection.prepareStatement(
					"UPDATE accounts a set a.amount = a.amount-? WHERE a.number = ?;");
				
				stmt2.setInt(1, amount);
				stmt2.setInt(2, fromAccount);
				
				stmt2.executeUpdate();
						
				stmt3 = connection.prepareStatement(
					"UPDATE accounts a set a.amount = a.amount+? WHERE a.number = ?;");
			
			
				stmt3.setInt(1, amount);
				stmt3.setInt(2, toAccount);
			
				stmt3.executeUpdate();
			
				connection.commit();
				
				System.out.println("\nUpdate:");
				}
			
	
			
			}catch(SQLException ex) {
	        	System.out.println("SQLException: " + ex.getMessage());
	        	System.out.println("SQLState: " + ex.getSQLState());
	        	System.out.println("VendorError: " + ex.getErrorCode());
	        	
	        try {
				connection.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	
	        }finally{
	        	
	        	try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
					
					try {
						stmt1.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					try {
						stmt2.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
					
					try {
						connection.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
				}

			
			
		}

	public void getEverything() {
		PreparedStatement stmt = null;
		
		
		ResultSet rs = null;
		
		Connection connection = null;
		try {
			
			connection  = bankfactory.getConnection();
		
			stmt = connection.prepareStatement(
					"SELECT * from accounts");
			
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				
				System.out.print("\nAcc number: " + rs.getInt("number"));
				System.out.println(" Amount: " + rs.getInt("amount"));
			}
		
		
		
		

		
		}catch(SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
        	System.out.println("SQLState: " + ex.getSQLState());
        	System.out.println("VendorError: " + ex.getErrorCode());
        	
        	
        	
        }finally{
        	
        	try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
				
				try {
					stmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
			
				
				try {
					connection.close();
				}catch(SQLException ee) {
					ee.printStackTrace();
				}
			}

        }
	}

}
