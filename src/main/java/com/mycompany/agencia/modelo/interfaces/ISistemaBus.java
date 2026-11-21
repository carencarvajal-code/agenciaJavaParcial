/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agencia.modelo.interfaces;

/**
 *
 * @author caren
 */


public interface ISistemaBus {
    boolean reservarPasajeBus(String dni, String nombreCompleto, int cantidadAsientos, String fecha, String hora, String origen, String destino);
}