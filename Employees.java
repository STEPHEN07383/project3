package javaprojects;

import java.sql.*;

public class Employees {
			
	  public static void main(String[] args) {

		 try {
		  // Load the MySQL driver
		  Class.forName("com.mysql.cj.jdbc.Driver");

		 // Connect to the database
	    String url = "jdbc:mysql://localhost:3306/factory";
	    String username = "root";
		String password = "Rastring*07";
		Connection conn = DriverManager.getConnection(url, username, password);

		// Create a SQL statement
		Statement stmt = conn.createStatement();

		String sqlInsert = "INSERT INTO employees (first_name, last_name, email, hire_date, job_title, phone_number) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
		insertStmt.setString(1, "James");
		insertStmt.setString(2, "Maron");
		insertStmt.setString(3, " james@TEST.com");
		insertStmt.setString(4, "2023-05-01");
		insertStmt.setString(5, "Machine Operator");
		insertStmt.setString(6, "0723019458");
		int rowsInserted = insertStmt.executeUpdate();
		 System.out.println(rowsInserted + " row(s) inserted.");

	// Execute the SQL query and get the results
	ResultSet result = stmt.executeQuery("SELECT * FROM factory.employees");

	// Print out the results
	while (result.next()) {
	  System.out.println(result.getString("first_name") + ", " + result.getString("last_name") + ", " + result.getString("email") + ", " + result.getString("job_title") + ", " + result.getInt("phone_number"));
	 }

   // Close the connection
	 conn.close();
 } catch (Exception e) {
  System.err.println("Exception: " + e.getMessage());
	      }
	 }
}


