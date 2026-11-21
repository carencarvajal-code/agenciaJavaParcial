/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agencia.modelo;

/**
 *
 * @author caren
 */
public abstract class ProductoTuristico {
    protected String codigo;
    protected String descripcion;
    protected double costoBase;
    protected String estado; 
    public abstract void reservar(Cliente cliente, Paquete paquete) throws Exception;
    public abstract void confirmar(Cliente cliente, Paquete paquete) throws Exception;

    
    public double getCostoBase() { return costoBase; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}