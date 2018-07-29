
package elpoeta.demopost.conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author elpoeta
 */
public class Conexion {
    private static Conexion INSTANCE = null;
     private static String LABASE = "jdbc:mysql://localhost/db_demopost";
     private static String LABASEUSUARIO = "elpoeta";  // "root";
     private static String LABASECLAVE = "elpoeta";    //"root";

	
	public static Conexion getInstance() throws ClassNotFoundException, IOException, SQLException {
         if (INSTANCE == null) {
             INSTANCE = new Conexion();
         }
         return INSTANCE;
     }
     private Conexion() throws ClassNotFoundException,
             IOException, SQLException {
     }

     public Connection getConnection() throws ClassNotFoundException,
             IOException, SQLException {
         Class.forName("com.mysql.cj.jdbc.Driver");
         return DriverManager.getConnection(LABASE, LABASEUSUARIO, LABASECLAVE);
     }
}
