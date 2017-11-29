import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


// Notice, do not import com.mysql.jdbc.*
// or you will have problems!

public class MainTestClass {
    public static void main(String[] args) throws SQLException {
       
    	try {
    	
    	// Instansierar ny NorthwindConnectionFactory
    	NorthwindConnectionFactory nwcf = new NorthwindConnectionFactory();
        
    	Connection connection = nwcf.getConnection();
        
        // Instansierar ett GetData objekt
        GetDataNorthwind getData = new GetDataNorthwind(connection);
        
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
        			productSearchSet.getInt("UnitPrice") + "kr " +
        			productSearchSet.getInt("UnitsInStock") + "st");
        	
        }
        
        // Personaltest getById
        
        PersonalDAO personalDAO = new PersonalDAO(new PersonalConnectionFactory());
        
        Personal personal = personalDAO.getById(7313);
        System.out.println("\nFound:\n" + personal.toString());
        
        // Personaltest updateById
        
        //System.out.println("\nUpdated:\n" + personal.toString());
        
        }catch(SQLException ex) {
        	System.out.println("SQLException: " + ex.getMessage());
        	System.out.println("SQLState: " + ex.getSQLState());
        	System.out.println("VendorError: " + ex.getErrorCode());
        }
        }
        
        
    
    
}
