/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.controlador;

/**
 *
 * @author caren
 */


import com.mycompany.agencia.dao.PaqueteDAO;
import com.mycompany.agencia.modelo.Cliente;
import com.mycompany.agencia.modelo.Paquete;
import com.mycompany.agencia.modelo.ProductoTuristico;
import java.util.List;

public class ControladorPaquete {
    private PaqueteDAO paqueteDAO;

    public ControladorPaquete() {
        this.paqueteDAO = new PaqueteDAO();
    }

    /**
     * Procesa la creación y cálculo de un paquete turístico y lo guarda en la BD.
     * @param nombrePaquete Nombre del paquete (Ej: "Calafate-Ushuaia")
     * @param fechaInicio Fecha de inicio
     * @param fechaFin Fecha de fin
     * @param cliente El objeto cliente que solicita la reserva
     * @param productos Lista de productos turísticos (vuelos, hoteles, excursiones)
     * @return true si se guardó con éxito en MariaDB
     */
    public boolean registrarYGuardarPaquete(String nombrePaquete, String fechaInicio, String fechaFin, Cliente cliente, List<ProductoTuristico> productos) {
        try {
            // 1. Creamos el objeto Paquete del Modelo
            Paquete paquete = new Paquete();
            paquete.setNombrePaquete(nombrePaquete);
            paquete.setFechaInicio(fechaInicio);
            paquete.setFechaFin(fechaFin);
            paquete.setCliente(cliente);
            paquete.setProductos(productos);

            // 2. Ejecutamos la regla de negocio para calcular costos y recargos
            paquete.calcularPrecioFinal();

            // 3. Recorremos los productos para ejecutar sus reservas externas (simuladas por las interfaces)
            for (ProductoTuristico producto : productos) {
                producto.reservar(cliente, paquete);
            }

            // 4. Guardamos el paquete en la base de datos a través del DAO
            boolean guardadoExitoso = paqueteDAO.guardarPaquete(paquete);
            
            return guardadoExitoso;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
