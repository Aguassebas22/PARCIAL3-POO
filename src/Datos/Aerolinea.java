
package Datos;


import java.util.ArrayList;
import java.util.List;

public class Aerolinea {
    private String nombre;
    private List<Vuelo> vuelos;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }
}
