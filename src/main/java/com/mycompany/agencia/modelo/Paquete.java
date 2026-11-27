/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.modelo;

/**
 *
 * @author caren
 */

import java.util.List;

public class Paquete {
    private String nombrePaquete;
    private String fechaInicio;
    private String fechaFin;
    private List<ProductoTuristico> productos;
    private Cliente cliente;
    private double costoTotal;
    private double precioFinal;

    public void calcularPrecioFinal() {
        double sumaCostos = 0;
        for (ProductoTuristico p : productos) {
            sumaCostos += p.getCostoBase();
        }
        
        double recargo = 0;
        String tipo = cliente.getTipoCliente().toLowerCase();
        String nacionalidad = cliente.getNacionalidad().toLowerCase();

        if (tipo.equals("mayorista")) {
            recargo = 15.0; // $15 fijos
        } else if (nacionalidad.equals("nacional")) {
            recargo = sumaCostos * 0.10; // 10% del costo original
        } else if (nacionalidad.equals("extranjero")) {
            double veintePorciento = sumaCostos * 0.20;
            recargo = Math.max(veintePorciento, 500.0); // El mayor valor entre 20% y $500
        }

        this.costoTotal = sumaCostos;
        this.precioFinal = sumaCostos + recargo;
    }
    

    

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<ProductoTuristico> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoTuristico> productos) {
        this.productos = productos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
    
}
