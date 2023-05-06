package javaprojects;

import java.sql.*;

public class RawMaterials {

			
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

		   String sqlInsert = "INSERT INTO raw_materials (id, material_name, supplier_id, quantity, date_received, price) VALUES (?, ?, ?, ?, ?, ?)";
		   PreparedStatement insertStmt = conn.prepareStatement(sqlInsert);
		   insertStmt.setString(1, "23748219");
		   insertStmt.setString(2, "Fuel");
		   insertStmt.setString(3, "05628791");
		   insertStmt.setString(4, "32980");
		   insertStmt.setString(5, "20230430");
		   insertStmt.setString(6, "5903420");
		   int rowsInserted = insertStmt.executeUpdate();
		   System.out.println(rowsInserted + " row(s) inserted.");

	   // Execute the SQL query and get the results
	   ResultSet result = stmt.executeQuery("SELECT * FROM factory.raw_materials");

	   // Print out the results
	   while (result.next()) {
		System.out.println(result.getInt("id") + ", " + result.getString("material_name") + ", " + result.getInt("supplier_id") + ", "
				+ "" + result.getInt("quantity") + ", " + result.getInt("date_received") +"," + result.getInt("price"));
			 }

	   // Close the connection
	  conn.close();
		 } catch (Exception e) {
		 System.err.println("Exception: " + e.getMessage());
			    }
			  }
			}

