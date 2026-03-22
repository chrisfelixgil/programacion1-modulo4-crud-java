
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Private: Significa que la variable solo se puede usar dentro de esa clase.
 * Static: Significa que la variable pertenece a la clase, no a los objetos. 
 * Final: Significa que el valor no se puede cambiar.
 */
public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/itla_db";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    public static Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return con;
    }
    
    
    
}
