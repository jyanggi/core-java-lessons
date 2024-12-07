package lessons.v8.ocp.chapter10;

import java.sql.*;

public class DerbyExample {
    public static void main(String[] args) {
        String url = "jdbc:derby:myDB;create=true"; // Create a new database named 'myDB'
        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            System.out.println("Database created successfully!");
            try{
                stmt.executeUpdate("CREATE TABLE species ("
                  + "id INTEGER PRIMARY KEY, "
                  + "name VARCHAR(255), "
                  + "num_acres DECIMAL)");
                stmt.executeUpdate(
                  "CREATE TABLE animal ("
                    + "id INTEGER PRIMARY KEY, "
                    + "species_id integer, "
                    + "name VARCHAR(255), "
                    + "date_born TIMESTAMP)");
                stmt.executeUpdate("INSERT INTO species VALUES (1, 'African Elephant', 7.5)");
                stmt.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
                stmt.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', CURRENT_TIMESTAMP)");
                stmt.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', CURRENT_TIMESTAMP)");
                stmt.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', CURRENT_TIMESTAMP)");
                stmt.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', CURRENT_TIMESTAMP)");
                stmt.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', CURRENT_TIMESTAMP)");

            }catch (Exception e){
                e.printStackTrace();
            }

            try(ResultSet rs =
                  stmt.executeQuery("select a.id, b.name, b.num_acres, a.name as animal_name, a.date_born from animal a inner join species b on a.species_id = b.id") ){

                while (rs.next()){
                    System.out.printf("%d %s %f %s %s\n",
                      rs.getInt(1),
                      rs.getString(2),
                      rs.getFloat(3),
                      rs.getString(4),
                      rs.getTimestamp(5)

                      );
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

