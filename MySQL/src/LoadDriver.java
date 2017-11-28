import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class LoadDriver {
    public static void main(String[] args) throws SQLException {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            // handle the error
        }
        
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/northwind?" +
                                           "user=root&password=123456&useSSL=false");

            // Do something with the Connection

           
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        GetData getData = new GetData(connection);
        
        Statement stmt = connection.createStatement();
	    
	    ResultSet result = stmt.executeQuery("SELECT EmployeeID, FirstName, LastName, Birthdate FROM employees");
	    
	    while(result.next())
	    {
	    	System.out.println(result.getString("EmployeeID") + " " + result.getString("FirstName") + " " + result.getString("LastName") + " " + result.getDate("BirthDate"));//or getString(1) for coloumn 1 etc
	    }
        
        System.out.println("\nVad var det totala ordervärdet som\r\n" +
        		"skeppades med Federal Shipping under 1997?\n" + getData.getCompanyOrderTotal("Federal Shipping", 1997) + " SEK\n");
        
        String customer = "HANAR";
        ResultSet allOrders = getData.showAllOrders(customer);
        
        while(allOrders.next())
        
        System.out.println(allOrders.getString("OrderID") + " " + allOrders.getString("CustomerID") + " " + allOrders.getDate("OrderDate") + " " + allOrders.getString("Total"));
    }
}
