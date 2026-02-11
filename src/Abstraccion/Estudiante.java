package Abstraccion;

class Estudiante implements Comparable<Estudiante> {

    private final String nombre;
    private final int edad;
    private final int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAltura() {
        return altura;
    }

    @Override
    public int compareTo(Estudiante otro) {
        // Altura de mayor a menor
        int comparacionAltura = Integer.compare(otro.altura, this.altura);

        if (comparacionAltura != 0) {
            return comparacionAltura;
        }
        // Si altura coincide, ordenar por edad (mayor a menor)
        return Integer.compare(otro.edad, this.edad);
    }

    @Override
    public String toString() {
        return nombre + " - Altura: " + altura + " - Edad: " + edad;
    }
}