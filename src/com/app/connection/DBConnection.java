
package com.app.connection;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author casper
 */
public class DBConnection {
    private static Connection conn = null;
    
    static {
        if (conn == null) {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setDatabaseName("akademik");
            ds.setUser("azeezee");
            ds.setPassword("123");
            
            try {
                conn = ds.getConnection();
                
            } catch (SQLException ex) {
                
            }
        }
    }
    
    public static Connection getConn() {
        return conn;
    }
}
