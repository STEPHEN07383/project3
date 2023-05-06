package javaprojects;

import java.sql.*;

public class QualityControl {
 
	public static void main(String[] args) {

		 try {
		 // Load the MySQL driver
		 Class.forName("com.mysql.cj.jdbc.Driver");

	    // Connect to the database
	 String url = "jdbc:mysql://localhost:3306/factory";
	 String username = "root";
	 String password = "Rastring*07";
	 Connection conn = DriverManager.getConnection(url, username, password);
	 
	 //// Increase the size of the test_result column
     Statement alterStmt = conn.createStatement();
     alterStmt.executeUpdate("ALTER TABLE quality_control MODIFY test_result VARCHAR(100)");

		// Create a SQL statement
		Statement stmt = conn.createStatement();

		String sqlInsert = "INSERT INTO quality_control (id, product_name, test_date, test_result) VALUES (?, ?, ?, ?)";
		 PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
         insertStmt.setString(1, "92348710");
		 insertStmt.setString(2, "Maize Flour");
		 insertStmt.setString(3, "2023-04-27");
         insertStmt.setString(4, "The product is safe");				     
		 int rowsInserted = insertStmt.executeUpdate();
		System.out.println(rowsInserted + " row(s) inserted.");

	  // Execute the SQL query and get the results
		ResultSet result = stmt.executeQuery("SELECT * FROM factory.quality_control");

	// Print out the results
	 while (result.next()) {
	System.out.println(result.getInt("id") + ", " + result.getString("product_name") + ", " + result.getDate("test_date") + ", " + result.getString("test_result"));
		 }

	 // Close the connection
	 conn.close();
	} catch (Exception e) {
   System.err.println("Exception: " + e.getMessage());
				}
		  }
   }

