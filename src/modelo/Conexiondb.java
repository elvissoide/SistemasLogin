package modelo;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexiondb {
    Connection conexion;

    public Connection getConexion() {
        String url = "jdbc:mysql://localhost:3306/ejercicio1";
        String usuario = "root";
        String contrasena = "Gatito1011";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contrasena);
        } catch (Exception e){
            e.printStackTrace();
        }
        return conexion;
    }
}
