import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PersonalConnectionFactory implements ConnectionFactory{

		
		private static PersonalConnectionFactory instance;

		static{
			 try {
		         // The newInstance() call is a work around for some
		         // broken Java implementations

		         Class.forName("com.mysql.jdbc.Driver").newInstance();
		     } catch (Exception ex) {
		         System.out.println("Unable to load mysql jdbc driver: " + ex.getMessage());
		     }
			}

			@Override
			public Connection getConnection() {
				
				try {
			  
			        // Skapar connection till databasen
			        return DriverManager.getConnection("jdbc:mysql://localhost/personal?" +
				                       "user=root&password=123456&useSSL=false");
				}catch(SQLException e){
					System.out.println("Unable to connect to database");
					e.printStackTrace();
				}
				return null;
		
	}
			
			public static synchronized PersonalConnectionFactory getInstance(){
		        if(instance == null){
		            instance = new PersonalConnectionFactory();
		        }
		        return instance;
		    }

		
}
