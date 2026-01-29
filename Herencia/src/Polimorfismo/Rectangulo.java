package Polimorfismo;

public class Rectangulo extends Forma{
    double largo;
    double ancho;

    Rectangulo(double largo,double ancho) {
        super("Rectangulo");
        this.largo=largo;
        this.ancho=ancho;
    }

    @Override
    public double Area() {
        return largo*ancho;
    }
}
