package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/movies?serverTime=UTC";
        String user = "root";
        String password = "semp1990";

        Connection connection = null;
        Statement statement = null;

        try {
            //1. Create a connection
             connection = DriverManager.getConnection(url, user, password);

            //2. Create a statement
            statement = connection.createStatement();

            Movie fastAndFurious9 = new Movie(1000, "Fast & Furious 9", 2020, "Action", "R");

            String query = "insert into movie(id, title, release_year, genre, mpaa_rating)" + " values (" + fastAndFurious9.getId()
            + ", '" + fastAndFurious9.getTitle() + "', " + fastAndFurious9.getReleaseYear() + ", '" + fastAndFurious9.getGenre() + "', '" + fastAndFurious9.getMpaaRating()
            + "');";
                    statement.execute(query);
            //3. Execute the SQL query


            System.out.println("Movies added");

            //4. Process the result if necessary

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("something might have went wrong with the connection");
        } finally {
            statement.close();
            connection.close();




        }




    }
}
