
package sistemaaerolinea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Pasajero {
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
}

class Boleto {
    private Vuelo vuelo;
    private Pasajero pasajero;
    private String asiento;

    public Boleto(Vuelo vuelo, Pasajero pasajero, String asiento) {
        this.vuelo = vuelo;
        this.pasajero = pasajero;
        this.asiento = asiento;
    }

    public void imprimirBoleto() {
        System.out.println("Boleto:");
        System.out.println("Pasajero: " + pasajero.getNombre());
        System.out.println("Vuelo: " + vuelo.getIdentificador());
        System.out.println("Origen: " + vuelo.getOrigen());
        System.out.println("Destino: " + vuelo.getDestino());
        System.out.println("Asiento: " + asiento);
        System.out.println("Precio: $" + vuelo.getPrecio());
    }
}

class Vuelo {
    private String identificador;
    private String origen;
    private String destino;
    private double precio;
    private String[][] asientos;

    public Vuelo(String identificador, String origen, String destino, double precio, int filas, int columnas) {
        this.identificador = identificador;
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.asientos = new String[filas][columnas];
        inicializarAsientos();
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getPrecio() {
        return precio;
    }

    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = "Libre";
            }
        }
    }

    public void mostrarAsientos() {
        System.out.println("Asientos disponibles:");
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna].equals("Libre")) {
                asientos[fila][columna] = "Ocupado";
                return true;
            } else {
                System.out.println("El asiento ya está ocupado, seleccione otro.");
                return false;
            }
        } else {
            System.out.println("Opción inválida, por favor seleccione un asiento dentro del rango.");
            return false;
        }
    }
}

class Aerolinea {
    private String nombre;
    private List<Vuelo> vuelos;

    public Aerolinea(String nombre) {
        this.nombre = nombre;
        this.vuelos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }
}

class Aeropuerto {
    private String nombre;
    private String ciudad;
    private String pais;
    private boolean esPublico;
    private List<Aerolinea> aerolineas;

    public Aeropuerto(String nombre, String ciudad, String pais, boolean esPublico) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.esPublico = esPublico;
        this.aerolineas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void agregarAerolinea(Aerolinea aerolinea) {
        aerolineas.add(aerolinea);
    }

    public List<Aerolinea> getAerolineas() {
        return aerolineas;
    }
}

public class SistemaAerolinea {

    private static List<Aeropuerto> aeropuertos = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("---- Menú ----");
            System.out.println("1. Consultar aeropuertos en Colombia");
            System.out.println("2. Mostrar compañías en un aeropuerto");
            System.out.println("3. Reservar un boleto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida, por favor seleccione de nuevo.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    consultarAeropuertos();
                    break;
                case 2:
                    mostrarCompanias();
                    break;
                case 3:
                    reservarBoleto(scanner);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor seleccione de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void inicializarDatos() {
        Aeropuerto aeropuertoBogota = new Aeropuerto("El Dorado", "Bogotá", "Colombia", true);
        Aeropuerto aeropuertoMedellin = new Aeropuerto("José María Córdova", "Medellín", "Colombia", false);

        Aerolinea avianca = new Aerolinea("Avianca");
        avianca.agregarVuelo(new Vuelo("AV123", "Bogotá", "Medellín", 150.0, 5, 5));
        avianca.agregarVuelo(new Vuelo("AV456", "Bogotá", "Cali", 130.0, 5, 5));

        Aerolinea vivaAir = new Aerolinea("Viva Air");
        vivaAir.agregarVuelo(new Vuelo("VA789", "Medellín", "Bogotá", 140.0, 5, 5));
        vivaAir.agregarVuelo(new Vuelo("VA321", "Medellín", "Cartagena", 160.0, 5, 5));

        aeropuertoBogota.agregarAerolinea(avianca);
        aeropuertoMedellin.agregarAerolinea(vivaAir);

        aeropuertos.add(aeropuertoBogota);
        aeropuertos.add(aeropuertoMedellin);
    }

    private static void consultarAeropuertos() {
        System.out.println("Aeropuertos en Colombia:");
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println("- " + aeropuerto.getNombre() + " en " + aeropuerto.getCiudad());
        }
    }

    private static void mostrarCompanias() {
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println("Aeropuerto " + aeropuerto.getNombre() + " en " + aeropuerto.getCiudad() + " tiene:");
            for (Aerolinea aerolinea : aeropuerto.getAerolineas()) {
                System.out.println("- " + aerolinea.getNombre());
            }
        }
    }

    private static void reservarBoleto(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su número de pasaporte: ");
        String numeroPasaporte = scanner.nextLine();
        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        Pasajero pasajero = new Pasajero(nombre, numeroPasaporte, nacionalidad);

        System.out.println("Seleccione un vuelo:");
        for (Aeropuerto aeropuerto : aeropuertos) {
            for (Aerolinea aerolinea : aeropuerto.getAerolineas()) {
                for (Vuelo vuelo : aerolinea.getVuelos()) {
                    System.out.println(vuelo.getIdentificador() + " - " + vuelo.getOrigen() + " a " + vuelo.getDestino() + " - $" + vuelo.getPrecio());
                }
            }
        }

        Vuelo vueloSeleccionado = null;
        while (vueloSeleccionado == null) {
            System.out.print("Ingrese el identificador del vuelo: ");
            String idVuelo = scanner.nextLine();

            for (Aeropuerto aeropuerto : aeropuertos) {
                for (Aerolinea aerolinea : aeropuerto.getAerolineas()) {
                    for (Vuelo vuelo : aerolinea.getVuelos()) {
                        if (vuelo.getIdentificador().equals(idVuelo)) {
                            vueloSeleccionado = vuelo;
                            break;
                        }
                    }
                }
            }
            if (vueloSeleccionado == null) {
                System.out.println("Vuelo no encontrado. Opción inválida, por favor seleccione de nuevo.");
            }
        }

        vueloSeleccionado.mostrarAsientos();

        boolean asientoReservado = false;
        while (!asientoReservado) {
            System.out.print("Ingrese la fila del asiento: ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna del asiento: ");
            int columna = scanner.nextInt();
            scanner.nextLine();

            if (vueloSeleccionado.reservarAsiento(fila, columna)) {
                asientoReservado = true;
                String asiento = fila + "-" + columna;
                Boleto boleto = new Boleto(vueloSeleccionado, pasajero, asiento);
                boleto.imprimirBoleto();
            }
        }
    }
}
