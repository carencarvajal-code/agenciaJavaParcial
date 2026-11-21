/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agencia.modelo.interfaces;

/**
 *
 * @author caren
 */

public interface ISistemaAereo {
    boolean reservarVuelo(String dni, String nombreCompleto, String fecha, String nroVuelo, String origen, String destino, String tipoPasaje);
}
