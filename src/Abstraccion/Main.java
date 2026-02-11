package Abstraccion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Patri", 12, 170));
        estudiantes.add(new Estudiante("Manuel", 43, 173));
        estudiantes.add(new Estudiante("Javier", 72, 189));
        estudiantes.add(new Estudiante("Alicia", 52, 168));
        estudiantes.add(new Estudiante("Alberto", 35, 189));

        System.out.println("Estudiantes sin ordenar:");
        imprimirLista(estudiantes);

        Collections.sort(estudiantes);

        System.out.println("\nEstudiantes ordenados:");
        imprimirLista(estudiantes);
    }

    public static void imprimirLista(List<Estudiante> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + ". " + lista.get(i));
        }
    }
}