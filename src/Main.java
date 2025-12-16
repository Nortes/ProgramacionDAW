// Ejemplo de partida de Git

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona p1=new Persona("pedro",20);
        Persona p2=new Persona("maria",40);
        Persona p3=new Persona("gema",15);
        Persona p4=new Persona("juan",30);
        ArrayList<Persona> lista=new ArrayList<Persona>();
        lista.add(p1);
        //asdfjlasdfa
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        for (Persona p:lista){
            System.out.println(p.toString());
        }
    }
}