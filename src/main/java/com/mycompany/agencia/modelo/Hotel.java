/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.modelo;

/**
 *
 * @author caren
 */
import com.mycompany.agencia.modelo.interfaces.ISistemaHotel;

public class Hotel extends ProductoTuristico {
    private String nombreHotel;
    private String tipoHabitacion; // Simple, Doble, etc.
    private String fechaLlegada;
    private String fechaSalida;
    private ISistemaHotel servicioHotel;

    public Hotel(String nombreHotel, String tipoHabitacion, String fechaLlegada, String fechaSalida, double costoBase, ISistemaHotel servicioHotel) {
        this.nombreHotel = nombreHotel;
        this.tipoHabitacion = tipoHabitacion;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.costoBase = costoBase;
        this.servicioHotel = servicioHotel;
        this.estado = "Pendiente";
    }

    @Override
    public void reservar(Cliente cliente, Paquete paquete) {
        try {
            boolean exito = servicioHotel.reservarHabitacion(
                cliente.getDni(), 
                cliente.getNombreCompleto(), 
                nombreHotel, 
                tipoHabitacion, 
                fechaLlegada, 
                fechaSalida
            );
            this.estado = exito ? "Reservado" : "Reserva Pendiente";
        } catch (Exception e) {
            this.estado = "Reserva Pendiente";
        }
    }

    @Override
    public void confirmar(Cliente cliente, Paquete paquete) {
        this.estado = "Confirmado";
    }
}
