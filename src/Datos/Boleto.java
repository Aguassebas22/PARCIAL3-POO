
package Datos;

public class Boleto {
    private Vuelo vuelo;
    private Pasajero pasajero;
    private int numeroAsiento;

    public Boleto(Vuelo vuelo, Pasajero pasajero, int numeroAsiento) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.numeroAsiento = numeroAsiento;
    }

    public void imprimirBoleto() {
        System.out.println("---- Boleto ----");
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Número de Pasaporte: " + pasajero.getNumeroPasaporte());
        System.out.println("Vuelo: " + vuelo.getIdentificador());
        System.out.println("Origen: " + vuelo.getOrigen());
        System.out.println("Destino: " + vuelo.getDestino());
        System.out.println("Número de Asiento: " + numeroAsiento);
        System.out.println("Precio: $" + vuelo.getPrecio());
    }
}
