package Polimorfismo;

public class Cilindro extends Forma {
    double radio;
    double altura;

    Cilindro(double radio, double altura) {
        super("Cilindro");
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double Area() {
        return Math.PI*Math.pow(radio,2)*altura;
    }
}
