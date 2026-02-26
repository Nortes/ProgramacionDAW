package Planetas;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    // a) Map sistemaSolar
    private static final Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();

    // b) Set planetas
    private static final Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void main(String[] args) {

        // Añadimos planetas
        addPlaneta(new Planeta("Mercurio", 88));
        addPlaneta(new Planeta("Venus", 225));
        addPlaneta(new Planeta("La Tierra", 365));
        addPlaneta(new Planeta("Marte", 687));
        addPlaneta(new Planeta("Jupiter", 4332));
        addPlaneta(new Planeta("Saturno", 10759));
        addPlaneta(new Planeta("Urano", 30660));
        addPlaneta(new Planeta("Neptuno", 165));
        addPlaneta(new Planeta("Pluton", 248));

        //Satélites Tierra
        CuerpoCeleste luna = new Luna("Luna", 27);
        sistemaSolar.put(luna.getNombre(), luna);
        CuerpoCeleste tierra = sistemaSolar.get("La Tierra");
        tierra.addSatelite(luna);

        // Satélites Marte
        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put(deimos.getNombre(), deimos);
        sistemaSolar.put(phobos.getNombre(), phobos);

        CuerpoCeleste marte = sistemaSolar.get("Marte");
        marte.addSatelite(deimos);
        marte.addSatelite(phobos);

        // Satélites Júpiter
        CuerpoCeleste io = new Luna("Io", 1.8);
        CuerpoCeleste europa = new Luna("Europa", 3.5);
        CuerpoCeleste ganymede = new Luna("Ganymede", 7.1);
        CuerpoCeleste callisto = new Luna("Callisto", 16.7);

        sistemaSolar.put(io.getNombre(), io);
        sistemaSolar.put(europa.getNombre(), europa);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        sistemaSolar.put(callisto.getNombre(), callisto);

        CuerpoCeleste jupiter = sistemaSolar.get("Jupiter");
        jupiter.addSatelite(io);
        jupiter.addSatelite(europa);
        jupiter.addSatelite(ganymede);
        jupiter.addSatelite(callisto);

        //Imprimimos datos
        System.out.println("Planetas (nombre):");
        for (CuerpoCeleste p : planetas) {
            System.out.println("- " + p.getNombre());
        }

        // Imprimimos Marte
        System.out.println("\nLunas de Marte:");
        CuerpoCeleste marteDelMapa = sistemaSolar.get("Marte");
        for (CuerpoCeleste l : marteDelMapa.getSatelites()) {
            System.out.println("- " + l);
        }

        // Unión de las Lunas
        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste p : planetas) {
            lunas.addAll(p.getSatelites());
        }

        // Imprimimos lunas
        System.out.println("\nUnión de lunas: " + lunas.size());
        for (CuerpoCeleste l : lunas) {
            System.out.println("- " + l);
        }

        // Creando pluton
        CuerpoCeleste plutonNuevoPlaneta = new Planeta("Pluton", 884);
        boolean agregadoPlaneta = planetas.add(plutonNuevoPlaneta);

        System.out.println("\nPlanetas usando toString():");
        for (CuerpoCeleste p : planetas) {
            System.out.println("- " + p);
        }

        System.out.println("\n¿Se agregó Plutón-884 como PLANETA: " + agregadoPlaneta);
        System.out.println("Por qué: equals/hashCode solo miran nombre+tipo. Ya existía Plutón como PLANETA, así que el Set lo considera duplicado.");

        // Agregando Plutón como planeta enano
        CuerpoCeleste plutonEnano = new PlanetaEnano("Pluton", 884);
        boolean agregadoEnano = planetas.add(plutonEnano);

        System.out.println("\n¿Se agregó Plutón-884 como PLANETA_ENANO:  " + agregadoEnano);
        System.out.println("Por qué: el tipo cambia. Nombre igual, pero tipo distinto, así que equals da false y el Set lo acepta.");

        // Diferencia e intersección de Sets
        // Creamos un set de "lunas de Marte" y "lunas de Jupiter" para demostrar operaciones
        Set<CuerpoCeleste> lunasMarte = marte.getSatelites();
        Set<CuerpoCeleste> lunasJupiter = jupiter.getSatelites();

        // Intersección: elementos comunes
        Set<CuerpoCeleste> interseccion = new HashSet<>(lunasMarte);
        interseccion.retainAll(lunasJupiter);

        // Diferencia: lunasMarte - lunasJupiter
        Set<CuerpoCeleste> diferencia = new HashSet<>(lunasMarte);
        diferencia.removeAll(lunasJupiter);

        System.out.println("\nIntersección (lunas Marte - lunas Jupiter): " + interseccion.size());
        System.out.println("Esperado: 0, porque no comparten lunas.");
        for (CuerpoCeleste l : interseccion) {
            System.out.println("- " + l);
        }

        System.out.println("\nDiferencia (lunas Marte - lunas Jupiter): " + diferencia.size());
        System.out.println("Esperado: 2 (Deimos y Phobos).");
        for (CuerpoCeleste l : diferencia) {
            System.out.println("- " + l);
        }
    }

    private static void addPlaneta(CuerpoCeleste planeta) {
        sistemaSolar.put(planeta.getNombre(), planeta);
        planetas.add(planeta);
    }
}
