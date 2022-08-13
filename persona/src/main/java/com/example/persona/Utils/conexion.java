package com.example.persona.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private static String ipAddress = "localhost";
    private static String dbName = "persona";
    private static String user = "root";
    private static String password = "root";
    private static String portservice = "3306";

    public static Connection getConnection()
            throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en la base de datos");
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://"
                + ipAddress + ":" + portservice + "/"
                + dbName, user, password
        );
    }

    public static void main(String[] args) throws SQLException {
        Connection con = getConnection();
        System.out.println("Conexion realizada con exito: "+con);
        con.close();
    }

    public void desconectar() throws SQLException {
        getConnection().close();
    }
}