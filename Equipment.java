package javaprojects;

import java.sql.*;

public class Equipment {
    
    public static void main(String[] args) {

         try {
             // Load the MySQL driver
             Class.forName("com.mysql.cj.jdbc.Driver");

             // Connect to the database
             String url = "jdbc:mysql://localhost:3306/factory";
             String username = "root";
             String password = "Rastring*07";
             Connection conn = DriverManager.getConnection(url, username, password);

             // Increase the size of the last_maintenance_date column
             Statement alterStmt = conn.createStatement();
             alterStmt.executeUpdate("ALTER TABLE equipment MODIFY last_maintenance_date DATE");
             
          // Increase the size of the next_maintenance_date column
             Statement alterStmt1 = conn.createStatement();
             alterStmt.executeUpdate("ALTER TABLE equipment MODIFY next_maintenance_date DATE");

             // Create a SQL statement
             String sql = "INSERT INTO equipment (id, name, type, manufacturer, price, model, purchase_date, last_maintenance_date, next_maintenance_date) " +
                 "VALUES ('24748905', 'Conveyor Belt', 'The Big Black One', 'Mazuri Industries', '250000', 'RWSH', '2023-04-02', '2023-05-01', '2023-06-05')";
             Statement stmt = conn.createStatement();
             stmt.executeUpdate(sql);

             System.out.println(sql + " row(s) inserted.");

             // Execute the SQL query and get the results
             ResultSet result = stmt.executeQuery("SELECT * FROM factory.equipment");

             // Print out the results
             while (result.next()) {
                 System.out.println(result.getInt("id") + ", " + result.getString("name") + ", " + result.getString("type") + ", " + result.getString("manufacturer") + ", " + result.getInt("price")+ ", "
                     + "" + result.getString("model")+ ", " + result.getDate("purchase_date") + ", " + result.getDate("last_maintenance_date") +", " +result.getDate("next_maintenance_date"));
             }

             // Close the connection
             conn.close();
         } catch (Exception e) {
             System.err.println("Exception: " + e.getMessage());
         }
    }
}
