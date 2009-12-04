/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mycollection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tonismar
 */
public class DBConnection {

    private Connection conn;
    private Statement stm;

    public DBConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        this.conn = DriverManager.getConnection("jdbc:derby://localhost:1527/MyConnection");
        this.stm = this.conn.createStatement();
    }

    public void executeSQL(String sql) {
        try {
            this.stm = this.conn.createStatement();
            this.stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}