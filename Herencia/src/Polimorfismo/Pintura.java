package Polimorfismo;

public class Pintura {
    double cobertura;

    public Pintura(double cobertura){
        this.cobertura = cobertura;
    }

    public double pintar(Forma figura){
        return figura.Area()/cobertura;
    }
}
