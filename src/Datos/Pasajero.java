/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

public class Pasajero {
    private String nombre;
    private String numeroPasaporte;
    private String nacionalidad;

    public Pasajero(String nombre, String numeroPasaporte, String nacionalidad) {
        this.nombre = nombre;
        this.numeroPasaporte = numeroPasaporte;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroPasaporte() {
        return numeroPasaporte;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
}
