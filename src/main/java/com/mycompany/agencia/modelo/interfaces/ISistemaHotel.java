/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.agencia.modelo.interfaces;

/**
 *
 * @author caren
 */

public interface ISistemaHotel {
    boolean reservarHabitacion(String dni, String nombreCompleto, String hotel, String tipoHabitacion, String llegada, String salida);
}
