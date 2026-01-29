package Polimorfismo;

public abstract class Forma {
    String nombre;

    Forma(String nombre) {
        this.nombre = nombre;
    }

    abstract public double Area();

    public String toString() {
        return nombre;
    }
}
