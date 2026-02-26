package Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public Main() {

        ubicaciones.put(0, new Ubicacion(0,"Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4,new Ubicacion(4,"Estas de pie en un puente"));
        ubicaciones.put(5,new Ubicacion(5,"Estas en un bosque"));

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("O", 2);

        // 2: Playa -> E Montaña, S Puente, N Bosque
        ubicaciones.get(2).addExit("E", 1);
        ubicaciones.get(2).addExit("S", 4);
        ubicaciones.get(2).addExit("N", 5);

        // 3: Edificio -> O Montaña
        ubicaciones.get(3).addExit("O", 1);

        // 4: Puente -> N Montaña, O Playa
        ubicaciones.get(4).addExit("N", 1);
        ubicaciones.get(4).addExit("O", 2);

        // 5: Bosque -> S Montaña, O Playa (esto cuadra con el ejemplo: "S, O, Q")
        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);

        // Añadir salida Q -> 0 en todas las ubicaciones 1..5
        for (int i = 1; i <= 5; i++) {
            ubicaciones.get(i).addExit("Q", 0);
        }

    }
    public void ejecuta() {
        try (Scanner scanner = new Scanner(System.in)) {
            int ubicacionActual = 1;
            System.out.println(ubicaciones.get(ubicacionActual).getDescripcion());

            boolean salir = false;
            while (!salir) {
                Ubicacion u = ubicaciones.get(ubicacionActual);
                System.out.print("Tus salidas válidas son ");

                // Mostrar salidas
                StringBuilder sb = new StringBuilder();
                for (String dir : u.getExits().keySet()) {
                    sb.append(dir).append(", ");
                }
                if (sb.length() >= 2) sb.setLength(sb.length() - 2);
                System.out.println(sb);

                System.out.print("INPUT: ");
                String direccion = scanner.nextLine().trim().toUpperCase();

                // Sí quiere salir
                if (direccion.equals("Q")) {
                    salir = true;
                    continue;
                }

                // Validar dirección
                Integer siguienteId = u.getExits().get(direccion);
                if (siguienteId == null) {
                    System.out.println("No puede ir en esa dirección");
                    continue;
                }

                // Validar que la ubicación exista en el mapa
                Ubicacion siguienteUbicacion = ubicaciones.get(siguienteId);
                if (siguienteUbicacion == null) {
                    System.out.println("No puedes ir a ese lugar.");
                    continue;
                }

                ubicacionActual = siguienteId;
                System.out.println(siguienteUbicacion.getDescripcion());
            }
        }
    }

    public static void main(String[] args) {
        new Main().ejecuta();
    }
}

