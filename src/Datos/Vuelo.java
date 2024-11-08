
package Datos;

// ... (previous imports and classes remain the same until Vuelo class)

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

    // ... (previous getters remain the same)

    private void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            for (int j = 0; j < asientos[i].length; j++) {
                asientos[i][j] = "[ ]"; // Asiento libre
            }
        }
    }

    public void mostrarAsientos() {
        System.out.println("\nMapa de asientos para el vuelo " + identificador + ":");
        System.out.println("[ ] = Libre");
        System.out.println("[X] = Ocupado\n");
        
        // Mostrar números de columna
        System.out.print("   "); // Espacio para alinear con las filas
        for (int j = 0; j < asientos[0].length; j++) {
            System.out.printf(" %d  ", j);
        }
        System.out.println();

        // Mostrar asientos con números de fila
        for (int i = 0; i < asientos.length; i++) {
            System.out.printf("%d  ", i); // Número de fila
            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila >= 0 && fila < asientos.length && columna >= 0 && columna < asientos[0].length) {
            if (asientos[fila][columna].equals("[ ]")) {
                asientos[fila][columna] = "[X]"; // Marcar como ocupado
                System.out.println("\n¡Asiento reservado exitosamente!");
                return true;
            } else {
                System.out.println("\n¡Error! El asiento ya está ocupado. Por favor, seleccione otro asiento.");
                mostrarAsientos(); // Mostrar nuevamente los asientos disponibles
                return false;
            }
        } else {
            System.out.println("\n¡Error! Selección fuera de rango. Por favor, elija un asiento válido.");
            mostrarAsientos(); // Mostrar nuevamente los asientos disponibles
            return false;
        }
    }

    String getPrecio() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getDestino() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getOrigen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    String getIdentificador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

