package javaprojects;

import java.sql.*;

public class Products {
			
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

		String sqlInsert = "INSERT INTO products (product_id, product_name, price, description, raw_material_id) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
	    insertStmt.setString(1, "25374519");
		insertStmt.setString(2, "Maize Flour");
		insertStmt.setString(3, "210");
		insertStmt.setString(4, "Sifted maize flour");
		insertStmt.setString(5, "23748219");
		int rowsInserted = insertStmt.executeUpdate();
		 System.out.println(rowsInserted + " row(s) inserted.");

	// Execute the SQL query and get the results
	ResultSet result = stmt.executeQuery("SELECT * FROM factory.products");

	// Print out the results
	while (result.next()) {
	  System.out.println(result.getInt("product_id") + ", " + result.getString("product_name") + ", " + result.getInt("price") + ", " + result.getString("description") + ", " + result.getInt("raw_material_id"));
	 }

   // Close the connection
	 conn.close();
 } catch (Exception e) {
  System.err.println("Exception: " + e.getMessage());
	      }
	 }
}


