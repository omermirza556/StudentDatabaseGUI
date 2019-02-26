import java.sql.*;

/**
 * This class contains a main method
 * 
 * This class creates a database and then populates the database with tables for
 * our student database.
 * 
 * I am thinking of adding a modification to the createNEW table method to take
 * user writter queries
 * 
 * @author omer
 *
 */
public class Bootstrap {

	/**
	 * creates the database
	 * 
	 * @param fileName
	 *            the file name
	 */
	public static void createNewDatabase(String fileName) {
		Connection c = null;
		String url = "jdbc:sqlite:" + fileName;

		try (Connection conn = DriverManager.getConnection(url)) {
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("A new database has been created.");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	// try {
	// Class.forName("org.sqlite.JDBC");
	// c = DriverManager.getConnection(url);
	// } catch (Exception e) {
	// System.err.println(e.getClass().getName() + ": " + e.getMessage());
	// System.exit(0);
	// }

	// System.out.println("Opened database successfully");

	//
	// try (Connection conn = DriverManager.getConnection(url)) {
	// if (conn != null) {
	// DatabaseMetaData meta = conn.getMetaData();
	// System.out.println("The driver name is " + meta.getDriverName());
	// System.out.println("A new database has been created.");
	// }
	//
	// } catch (SQLException e) {
	// System.out.println(e.getMessage());
	// }
	// }

	/**
	 * creates tables in the database
	 * 
	 * @param fileName
	 *            the file name
	 */
	public static void createNewTable(String fileName) {
		String url = "jdbc:sqlite:" + fileName;

		String courseSQL = "CREATE TABLE IF NOT EXISTS course (\n" + "cid Text PRIMARY KEY, \n"
				+ " days text NOT NULL, \n" + "spots integer NOT NULL, \n" + "spotsTaken integer NOT NULL, \n"+ " time text NOT NULL, \n" + " name text NOT NULL, \n"
				+ " description text NOT NULL, \n" + "CHECK (spotsTaken <= spots) \n"+ ");";
		String enrollSQL = "CREATE TABLE IF NOT EXISTS enroll(\n" + "cid Text NOT NULL, \n"
				+ " studid integer NOT NULL \n" + ");";
		String studentSQL = "CREATE TABLE IF NOT EXISTS student(\n" + "studid integer PRIMARY KEY, \n"
				+ "email text NOT NULL, \n" + " box integer NOT NULL, \n" + "fname text NOT NULL, \n" + "mname text, \n"
				+ "lname text NOT NULL, \n" + "class text NOT NULL \n" + ");";

		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(studentSQL);
			stmt.execute(enrollSQL);
			stmt.execute(courseSQL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

	public static void main(String[] args) {
		System.out.println("I want to die");
		createNewDatabase("school.db");
		createNewTable("school.db");
		// System.out.println("Tables created");
	}

}
