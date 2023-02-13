/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package org.uv.programa01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Itzel
 */
public class Programa01 {

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        Statement st = null;
        try {
            String sql = "INSERT INTO empleados (clave, nombre, direccion, telefono) "
                    + "VALUES ('02','Itzel','av 2','44444')";
            String url = "jdbc:postgresql://localhost:5432/ejemplo";
            String pwd = "123456";
            String user = "postgres";
            con = DriverManager.getConnection(url, user, pwd);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "Se conectó...");
            st = con.createStatement();
            st.execute(sql);
            Logger.getLogger(Programa01.class.getName()).log(Level.INFO, "Se guardó...");
            
        } catch (SQLException ex) {
            Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
        } finally { //proceso de cerrado para una buena practica
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Programa01.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
