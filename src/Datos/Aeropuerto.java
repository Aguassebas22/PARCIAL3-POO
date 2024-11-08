
package Datos;

import java.util.ArrayList;
import java.util.List;

public class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private boolean esPublico;
    private double financiamientoGobierno;
    private List<Aerolinea> aerolineas;

    public Aeropuerto(String nombre, String ciudad, String pais, boolean esPublico, double financiamientoGobierno) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.esPublico = esPublico;
        this.financiamientoGobierno = financiamientoGobierno;
        this.aerolineas = new ArrayList<>();
    }

    public void agregarAerolinea(Aerolinea aerolinea) {
        aerolineas.add(aerolinea);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getPais() {
        return pais;
    }

    public boolean esPublico() {
        return esPublico;
    }

    public List<Aerolinea> getAerolineas() {
        return aerolineas;
    }
}
