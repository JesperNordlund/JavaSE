import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


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
        
        // Skapar connection till databasen
        connection = DriverManager.getConnection("jdbc:mysql://localhost/northwind?" +
                                           "user=root&password=123456&useSSL=false");
        
        // Instansierar ett GetData objekt
        GetData getData = new GetData(connection);
        
        // Listar alla anställda
        ResultSet allEmployees = getData.getEmployees();
	    
	    while(allEmployees.next())	{
	    	
	    	System.out.println(
	    			allEmployees.getString("EmployeeID") + " " +
	    			allEmployees.getString("FirstName") + " " +
	    			allEmployees.getString("LastName") + " " +
	    			allEmployees.getDate("BirthDate"));
	    }
        
        System.out.println("\nVad var det totala ordervärdet som\r\n" +
        		"skeppades med Federal Shipping under 1997?\n" +
        		getData.getCompanyOrderTotal("Federal Shipping", 1997) + " SEK\n");
        
        // Listar order för vald customer
        String customer = "VICTE";
        ResultSet allOrders = getData.showAllOrders(customer);
        
        while(allOrders.next()) {
        
        	System.out.println(
        			allOrders.getString("OrderID") + " " +
        			allOrders.getString("CustomerID") + " " +
        			allOrders.getDate("OrderDate") + " " +
        			allOrders.getString("SummaMedRabatt"));
        }
        
        // Söker produkter
        String category = "Condiments";
        String searchString = "b";
        int maxPrice = 30;
        int unitsInStock = 75;
        
        
        ResultSet productSearchSet = getData.getProducts(category, searchString, maxPrice, unitsInStock);
        
        System.out.println("\nSökresultat:\n");
        
        while(productSearchSet.next()) {
        	
        	System.out.println(
        			productSearchSet.getString("ProductID") + " " +
        			productSearchSet.getString("ProductName") + " " +
        			productSearchSet.getString("CategoryName") + " " +
        			productSearchSet.getInt("UnitPrice") + " " +
        			productSearchSet.getInt("UnitsInStock"));
        	
        }
        
    
    }
}
