import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class GetDataNorthwind {
	
	private Connection connection;
	
	public GetDataNorthwind(Connection connection) {
		
		this.connection = connection;
	
	
}
	/** Listar all anställda
	 * 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getEmployees() throws SQLException {
	
	PreparedStatement stmt = connection.prepareStatement(
			"SELECT EmployeeID, FirstName, LastName, Birthdate " +
			"FROM employees");
    
    ResultSet rs = stmt.executeQuery();
    
    
	return rs;
	}
	
	/** Listar alla order gjorda av valt företag
	 * 
	 * @param company
	 * @param year
	 * @return ResultSet
	 * @throws SQLException
	 */
	public int getCompanyOrderTotal(String company, int year) throws SQLException {
		
		
		PreparedStatement stmt = connection.prepareStatement(
				"SELECT round(sum(UnitPrice * Quantity)) AS Totalsumma " + 
	    		"FROM `order details` od " + 
	    		"INNER JOIN orders o ON od.OrderID = o.OrderID " + 
	    		"INNER JOIN shippers s ON o.ShipVia = s.ShipperID " + 
	    		"WHERE s.CompanyName =? " + 
	    		"AND year(o.ShippedDate) =? " + 
	    		"AND o.ShippedDate IS NOT null;");
	    		
				stmt.setString(1, company);
				stmt.setInt(2, year);
	    		ResultSet rs = stmt.executeQuery();
	    		
	    int sum = 0;
	    while(rs.next()) {
	    sum = rs.getInt("Totalsumma");
	    }
	    
   
		return sum;

	}
	
	/** Listar samtliga order för en viss kund med totalpris med rabatten avdragen
	 * 
	 * @param customer
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet showAllOrders(String customer) throws SQLException {
		
		PreparedStatement stmt = connection.prepareStatement(
				"SELECT CustomerID, od.OrderID, OrderDate, " +
	    		"round(sum(UnitPrice * Quantity * (1 - Discount)), 2) AS SummaMedRabatt " +
	    		"FROM `order details` od " +
	    		"INNER JOIN orders o ON od.OrderID = o.OrderID " +
	    		"WHERE o.CustomerID =? " +
	    		"GROUP BY OrderID " +
				"ORDER BY OrderDate DESC;");

		stmt.setString(1, customer);
		ResultSet rs = stmt.executeQuery();
			
		return rs;
	}
	
	/** Sökfunktion för produkter
	 * 
	 * @param category
	 * @param searchString
	 * @param maxPrice
	 * @param unitsInStock
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet getProducts(String category, String searchString, int maxPrice, int unitsInStock) throws SQLException {
		
		PreparedStatement stmt = connection.prepareStatement(
				"SELECT ProductID, ProductName, CategoryName, UnitPrice, UnitsInStock " +
				"FROM products p " +
				"INNER JOIN categories o ON p.CategoryID = o.CategoryID " +
				"WHERE CategoryName = ? " +
				"AND ProductName LIKE CONCAT('%', ?, '%') " +
			    "AND UnitPrice <= ? " +
			    "AND UnitsInStock >= ?;");
		
		stmt.setString(1, category);
		stmt.setString(2, searchString);
		stmt.setInt(3, maxPrice);
		stmt.setInt(4, unitsInStock);
		
		ResultSet rs = stmt.executeQuery();
		
		
		return rs;
		
		
	}

}
