package LinkedList;

import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static void printMenu() {
        System.out.println("""
                Opciones:
                0 - Salir de la lista de reproducción
                1 - Reproducir siguiente canción
                2 - Reproducir canción previa
                3 - Repetir canción actual
                4 - Imprimir lista de canciones en la playlist
                5 - Volver a imprimir el menú
                """);
    }

    // Imprimir playlist usando iteradores
    private static void printPlayList(LinkedList<Cancion> playList) {
        System.out.println("\n=== PLAYLIST ===");
        Iterator<Cancion> it = playList.iterator();
        int i = 1;
        while (it.hasNext()) {
            System.out.println(i + ". " + it.next());
            i++;
        }
        System.out.println("================\n");
    }

    // Reproductor
    private static void play(LinkedList<Cancion> playList) {
        if (playList.isEmpty()) {
            System.out.println("La playlist está vacía. No hay nada que reproducir.");
            return;
        }

        ListIterator<Cancion> iterator = playList.listIterator();
        boolean avance = true;
        boolean quit = false;

        // Arrancamos con la primera
        Cancion current = iterator.next();
        System.out.println("Reproduciendo: " + current);

        printMenu();

        while (!quit) {
            System.out.print("Elige opción: ");
            int action;

            // Lectura segura de entero
            try {
                action = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Eso no es un número. Intenta otra vez.");
                continue;
            }

            switch (action) {
                case 0 -> {
                    System.out.println("Saliendo de la playlist.");
                    quit = true;
                }
                case 1 -> { // siguiente
                    if (!avance) {
                        // si veníamos hacia atrás, ajustamos posición
                        if (iterator.hasNext()) iterator.next();
                        avance = true;
                    }

                    if (iterator.hasNext()) {
                        current = iterator.next();
                        System.out.println("Reproduciendo: " + current);
                    } else {
                        System.out.println("Has llegado al final de la playlist. No hay siguiente canción.");
                    }
                }
                case 2 -> { // previa
                    if (avance) {
                        // si veníamos hacia delante, ajustamos posición
                        if (iterator.hasPrevious()) iterator.previous();
                        avance = false;
                    }

                    if (iterator.hasPrevious()) {
                        current = iterator.previous();
                        System.out.println("Reproduciendo: " + current);
                    } else {
                        System.out.println("Estás al inicio de la playlist. No hay canción previa.");
                    }
                }
                case 3 -> { // repetir actual
                    System.out.println("Repitiendo: " + current);
                }
                case 4 -> printPlayList(playList);
                case 5 -> printMenu();
                default -> System.out.println("Opción no válida.");
            }
        }
    }
    public static void main(String[] args) {

        // ===== base de datos musical
        ArrayList<Album> baseDeDatos = new ArrayList<Album>();
        // ===== Playlist =====
        LinkedList<Cancion> playList = new LinkedList<>();

        Album album001= new Album("All Hope Is Gone", "Slipknot");

        album001.addCancion(".execute.", 1.49);
        album001.addCancion("Gematria (The Killing Name)", 6.02);
        album001.addCancion("Sulfur", 4.37);
        album001.addCancion("Psychosocial", 4.43);
        album001.addCancion("Dead Memories", 4.28);
        album001.addCancion("Vendetta", 5.16);
        album001.addCancion("Butcher's Hook", 3.26);
        album001.addCancion("Gehenna", 6.05);
        album001.addCancion("This Cold Black", 4.41);
        album001.addCancion("Wherein Lies Continue", 3.56);
        album001.addCancion("Snuff", 6.22);
        album001.addCancion("All Hope Is Gone", 4.45);

        baseDeDatos.add(album001);
        System.out.println(album001.toString());

        Album album002 = new Album("The Black Parade", "My Chemical Romance");

        album002.addCancion("The End.", 1.52);
        album002.addCancion("Dead!", 3.15);
        album002.addCancion("This Is How I Disappear", 3.59);
        album002.addCancion("The Sharpest Lives", 3.20);
        album002.addCancion("Welcome to the Black Parade", 5.11);
        album002.addCancion("I Don't Love You", 3.58);
        album002.addCancion("House of Wolves", 3.04);
        album002.addCancion("Cancer", 2.22);
        album002.addCancion("Mama", 4.39);
        album002.addCancion("Sleep", 4.43);
        album002.addCancion("Teenagers", 2.41);
        album002.addCancion("Disenchanted", 4.55);
        album002.addCancion("Famous Last Words", 4.59);
        album002.addCancion("Blood", 1.28);

        baseDeDatos.add(album002);
        System.out.println(album002.toString());

        // Añadir por número de pista
        album001.addToPlayList(4, playList); // Psychosocial
        album001.addToPlayList(11, playList); // Snuff
        album002.addToPlayList(5, playList); // Welcome to the Black Parade

        // Añadir por nombre
        album001.addToPlayList("Sulfur", playList);
        album002.addToPlayList("Cancer", playList);
        album002.addToPlayList("Teenagers", playList);

        // Imprime playlist
        printPlayList(playList);

        // Reproducir
        play(playList);
    }

}
