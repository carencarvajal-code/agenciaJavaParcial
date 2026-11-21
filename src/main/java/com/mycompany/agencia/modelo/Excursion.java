/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.modelo;

/**
 *
 * @author caren
 */
import com.mycompany.agencia.modelo.interfaces.IServicioCorreo;

public class Excursion extends ProductoTuristico {
    private String operador;
    private String emailOperador;
    private String fecha;
    private String hora;
    private IServicioCorreo servicioCorreo;

    public Excursion(String descripcion, double costoBase, String operador, String emailOperador, String fecha, String hora, IServicioCorreo servicioCorreo) {
        this.descripcion = descripcion;
        this.costoBase = costoBase;
        this.operador = operador;
        this.emailOperador = emailOperador;
        this.fecha = fecha;
        this.hora = hora;
        this.servicioCorreo = servicioCorreo;
        this.estado = "Pendiente";
    }

    @Override
    public void reservar(Cliente cliente, Paquete paquete) {
        String asunto = "Reserva de Excursion / Traslado - " + operador;
        String cuerpo = "Estimado responsable de " + operador + ",\n\n" +
                        "Se solicita la reserva para el pasajero:\n" +
                        "- Nombre: " + cliente.getNombreCompleto() + "\n" +
                        "- DNI: " + cliente.getDni() + "\n" +
                        "- Fecha: " + fecha + "\n" +
                        "- Hora: " + hora + "\n" +
                        "- Detalle: " + descripcion + "\n\n" +
                        "Atentamente, Agencia de Turismo.";
        
        try {
            boolean enviado = servicioCorreo.enviarMail(emailOperador, asunto, cuerpo);
            this.estado = enviado ? "Reservado" : "Reserva Pendiente";
        } catch (Exception e) {
            this.estado = "Reserva Pendiente";
        }
    }

    @Override
    public void confirmar(Cliente cliente, Paquete paquete) {
        this.estado = "Confirmado";
    }
}
