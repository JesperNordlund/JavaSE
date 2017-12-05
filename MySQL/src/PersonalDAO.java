import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonalDAO {

	private static PersonalDAO instance;

	private PersonalConnectionFactory pcFactory;

	public PersonalDAO(PersonalConnectionFactory pcFactory) {

		this.pcFactory = pcFactory;
	}

	public static synchronized PersonalDAO getInstance() {
		if (instance == null) {
			instance = new PersonalDAO(PersonalConnectionFactory.getInstance());
		}
		return instance;
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

			stmt = connection.prepareStatement("SELECT * " + "FROM personal p " + "WHERE p.personalid = ?;");

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {

				personalId = rs.getInt("personalid");
				namn = rs.getString("namn");
				befattning = rs.getString("befattning");
				avdelningId = rs.getInt("avdelningId");
			}

			Personal personal = new Personal(personalId, namn, befattning, avdelningId);
			return personal;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally

		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	public Personal deleteById(int id) {

		PersonalDAO personalDAO = new PersonalDAO(new PersonalConnectionFactory());

		Personal personal = personalDAO.getById(id);

		PreparedStatement stmt = null;
		Connection connection = null;

		try {

			connection = pcFactory.getConnection();

			stmt = connection.prepareStatement("DELETE FROM personal " + "WHERE personalID = ?;");

			stmt.setInt(1, id);

			stmt.execute();

			System.out.println("\nDeleted:\n" + personal);

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally

		{

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personal;

	}

	public void updateNameById(int id, String newName) {

		int personalId = id;
		String namn = newName;

		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection connection = null;

		try {

			connection = pcFactory.getConnection();

			stmt = connection.prepareStatement("UPDATE namn " +
			"FROM personal p " + "SET p.personalid = ?;");

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {

				namn = rs.getString("namn");

			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally

		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void addById(String n, String b, int aId) {

		String namn = n;
		String befattning = b;
		int avdelningId = aId;

		PreparedStatement stmt = null;
		Connection connection = null;

		try {

			connection = pcFactory.getConnection();

			stmt = connection
					.prepareStatement("INSERT INTO personal (namn, befattning, avdelningID) VALUES\r\n" + "(?,?,?)");

			stmt.setString(1, namn);
			stmt.setString(2, befattning);
			stmt.setInt(3, avdelningId);

			stmt.execute();

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally

		{

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Personal getAll(int id) {

		int personalId = 0;
		String namn = null;
		String befattning = null;
		int avdelningId = 0;

		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection connection = null;

		try {

			connection = pcFactory.getConnection();

			stmt = connection.prepareStatement("SELECT * " + "FROM personal p " + "WHERE p.personalid = ?;");

			stmt.setInt(1, id);

			rs = stmt.executeQuery();

			while (rs.next()) {

				personalId = rs.getInt("personalid");
				namn = rs.getString("namn");
				befattning = rs.getString("befattning");
				avdelningId = rs.getInt("avdelningId");
			}

			Personal personal = new Personal(personalId, namn, befattning, avdelningId);
			return personal;

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally

		{
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;

	}
}
