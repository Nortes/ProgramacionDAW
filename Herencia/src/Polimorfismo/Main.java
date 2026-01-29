package Polimorfismo;

public class Main {
    public static void main(String[] args) {
        Pintura pincelGordo=new Pintura(250);
        Esfera esfera=new Esfera(15);
        Rectangulo rectangulo=new Rectangulo(20,35);
        Cilindro cilindro= new Cilindro(10, 30);

        System.out.println("Vamos a pintar.");

        System.out.println("Para pintar esta Esfera necesitamos "+Math.round(pincelGordo.pintar(esfera))+" pinceladas");
        System.out.println("Para pintar este Rectangulo necesitamos "+Math.round(pincelGordo.pintar(rectangulo))+" pinceladas");
        System.out.println("Para pintar este Cilindro necesitamos "+Math.round(pincelGordo.pintar(cilindro))+" pinceladas");
    }
}
