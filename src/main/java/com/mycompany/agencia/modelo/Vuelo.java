package com.mycompany.agencia.modelo;

import com.mycompany.agencia.modelo.interfaces.ISistemaAereo;

public class Vuelo extends ProductoTuristico {
    private String numeroVuelo;
    private String origen;
    private String destino;
    private String fecha;
    private String tipoPasaje;
    private ISistemaAereo servicioAereo;

    public Vuelo(String numeroVuelo, String origen, String destino, String fecha, String tipoPasaje, ISistemaAereo servicioAereo, double costoBase, String descripcion) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        this.tipoPasaje = tipoPasaje;
        this.servicioAereo = servicioAereo;
        this.costoBase = costoBase;
        this.descripcion = descripcion;
        this.estado = "Pendiente";
    }

    @Override
    public void reservar(Cliente cliente, Paquete paquete) {
        try {
            boolean exito = servicioAereo.reservarVuelo(
                cliente.getDni(), 
                cliente.getNombreCompleto(), 
                fecha, 
                numeroVuelo, 
                origen, 
                destino, 
                tipoPasaje
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

    // Getters y Setters necesarios
    public String getNumeroVuelo() { return numeroVuelo; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getFecha() { return fecha; }
    public String getTipoPasaje() { return tipoPasaje; }
}
