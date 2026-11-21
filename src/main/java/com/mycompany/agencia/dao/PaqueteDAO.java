/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.dao;

/**
 *
 * @author caren
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import com.mycompany.agencia.modelo.Paquete;

public class PaqueteDAO {
    private String url = "jdbc:mariadb://localhost:3306/agencia_turismo";
    private String usuario = "root";
    private String password = "tu_password";

    public Connection conectar() {
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(url, usuario, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public boolean guardarPaquete(Paquete paquete) {
        String sql = "INSERT INTO paquetes (nombre, fecha_inicio, fecha_fin, costo_total, precio_final) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conectar(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, paquete.getNombrePaquete());
            pst.setString(2, paquete.getFechaInicio());
            pst.setString(3, paquete.getFechaFin());
            pst.setDouble(4, paquete.getCostoTotal());
            pst.setDouble(5, paquete.getPrecioFinal());
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}