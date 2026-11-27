/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.modelo;

/**
 *
 * @author caren
 */
public class Cliente {
    private String dni;
    private String nombreCompleto;
    private String tipoCliente; // "Especial", "Riesgo", "Comun"
    private String nacionalidad; // "Nacional", "Extranjero"

    
    
    /**
     * Evalúa si el monto pagado cumple con la condición de confirmación del cliente.
     * @param montoTotal Precio total del paquete.
     * @param montoPagado Monto abonado hasta el momento.
     * @param cuotas Pagos realizados.
     * @return true si se debe confirmar la reserva.
     */
    public boolean cumpleCondicionConfirmacion(double montoTotal, double montoPagado, int cuotasPagadas) {
        switch (tipoCliente.toLowerCase()) {
            case "especial":
                // Se confirma con el primer pago de la cuota
                return cuotasPagadas >= 1;
            case "riesgo":
                // Se confirma recién cuando cancela todo el monto
                return montoPagado >= montoTotal;
            case "comun":
            default:
                // Se confirma cuando supera un % determinado (ej. 50% o según regla de negocio)
                double porcentajeRequerido = 0.50; // 50% por defecto
                return (montoPagado / montoTotal) >= porcentajeRequerido;
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setNombre(String cliente_de_Prueba) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}