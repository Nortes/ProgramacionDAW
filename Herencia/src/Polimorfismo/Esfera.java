package Polimorfismo;

public class Esfera extends Forma{
    double radio;

    Esfera(double radio) {
        super("Esfera");
        this.radio = radio;
    }

    @Override
    public double Area() {

        return 4*Math.PI*Math.pow(radio,2);
    }
}
