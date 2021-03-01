package sofka.co;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private final ResultSet resultSet = null;
    getCategoria DTO = new getCategoria();

    public void readDataBase() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "sofka_training";
            String pass = "BZenX643bQHw";
            connect = DriverManager.getConnection("jdbc:mysql://sofka-training.cpxphmd1h1ok.us-east-1.rds.amazonaws.com:3306/JonathanCastillo", user, pass);

            statement = connect.createStatement();
            ResultSet RS= statement.executeQuery("select * from category");
            writeResultSet(RS);

        } catch (Exception e) {
            System.out.println("Error en la conexion a la base de datos: ");
            throw e;
        } finally {
            close();
        }
    }
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            DTO.setName(resultSet.getString("name"));
            System.out.println("Nombre categoria: " + DTO.getName());
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}