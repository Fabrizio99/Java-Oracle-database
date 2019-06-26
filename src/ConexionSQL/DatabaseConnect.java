package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnect {
    public static Connection getConnection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String myDB = "jdbc:oracle:thin:@DESKTOP-59FHOE4:1521:XE";
            String usuario = "PROYECTOFINAL";
            String password = "123";
            Connection cnx = DriverManager.getConnection(myDB,usuario,password);
            return cnx;
        } catch(SQLException ex){
            System.out.println(ex.getMessage());
        } catch(ClassNotFoundException ex){
            Logger.getLogger(DatabaseConnect.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
}
