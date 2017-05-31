package ipm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David
 */
public class Koneksi {
    private static Connection conn;
    
    public static Connection getConn() throws SQLException {
        if (conn == null) {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ipm", "root", "");
        }
        return conn;
    }
}
