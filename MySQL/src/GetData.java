import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



public class GetData {
	
	private Connection connection;
	
	public GetData(Connection connection) {
		
		this.connection = connection;
	
	
}
	
	public int getCompanyOrderTotal(String company, int year) throws SQLException {
		
		
		Statement stmt = connection.createStatement();
	    
	    ResultSet rs = stmt.executeQuery("SELECT round(sum(UnitPrice * Quantity)) AS Totalsumma\r\n" + 
	    		"FROM `order details` od\r\n" + 
	    		"	INNER JOIN orders o ON od.OrderID = o.OrderID\r\n" + 
	    		"    INNER JOIN shippers s ON o.ShipVia = s.ShipperID\r\n" + 
	    		"WHERE s.CompanyName = '" + company + "'\r\n" + 
	    		"	AND year(o.ShippedDate) =" + year + "\r\n" + 
	    		"	AND o.ShippedDate IS NOT null;");
	    
	    int sum = 0;
	    while(rs.next()) {
	    sum = rs.getInt("Totalsumma");
	    }
	    
		return sum;

	}

	public ResultSet showAllOrders(String customer) throws SQLException {
		
Statement stmt = connection.createStatement();
	    
	    ResultSet rs = stmt.executeQuery("SELECT CustomerID, od.OrderID, OrderDate, round(sum(UnitPrice * Quantity) * (1 - Discount), 2) AS Total " +
	    		"FROM `order details` od " +
	    		"INNER JOIN orders o ON od.OrderID = o.OrderID " +
	    	"WHERE o.CustomerID = 'HANAR' " +
	    	"GROUP BY OrderID " +
	    	"ORDER BY OrderDate DESC;");
		
		return rs;
	}

}
