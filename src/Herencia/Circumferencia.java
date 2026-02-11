package Herencia;

public class Circumferencia extends Circulo{

    double altura;

    public Circumferencia(double radio,  double altura) {
        super(radio);

        if (altura<0){
            altura=0;
        }

        this.altura = altura;
    }

    public double getAltura() {
        return altura;
    }

    public double getVolume(){
        return this.getArea()*this.altura;
    }
}
