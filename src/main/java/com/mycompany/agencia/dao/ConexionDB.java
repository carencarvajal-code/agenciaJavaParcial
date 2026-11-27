/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/tu_base_de_datos"; // Cambia por el nombre de tu BD
    private static final String USER = "tu_usuario";       // Tu usuario de MariaDB (ej: root)
    private static final String PASSWORD = "tu_contraseña"; // Tu contraseña de MariaDB

    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("¡Conexión exitosa a MariaDB!");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el Driver JDBC de MariaDB.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de conexión a la Base de Datos.");
            e.printStackTrace();
        }
        return conexion;
    }
}