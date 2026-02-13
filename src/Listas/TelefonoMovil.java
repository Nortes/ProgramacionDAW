package Listas;

import java.util.ArrayList;

public class TelefonoMovil {
    private final String myNumber;
    private final ArrayList<Contacto> myContacts;

    public TelefonoMovil(String number) {
        myNumber = number;
        myContacts = new ArrayList<>();
    }

    public boolean addNewContact (Contacto numero){
        if(findContact(numero)>=0){
            return false;
        }

        myContacts.add(numero);
        return true;
    }

    public boolean updateContact (Contacto antiguo,Contacto nuevo){
        if(findContact(antiguo)<0||findContact(nuevo)>=0){
            return false;
        }else {
            if (myContacts.contains(antiguo)) {
                myContacts.set(myContacts.indexOf(antiguo), nuevo);
            }
            return true;
        }
    }

    public boolean removeContact (Contacto numero){
           if (findContact(numero) >= 0) {
               myContacts.remove(numero);
               return true;
           }

        return false;
    }

    private int findContact (Contacto numero){
        return myContacts.indexOf(numero);
    }

    private int findContact (String nombre){
        for(int i=0;i<myContacts.size();i++){
            if(myContacts.get(i).getName().equals(nombre)){
                return i;
            }
        }
        return -1;
    }

    public Contacto queryContact (String nombre){
        int index=findContact(nombre);
        if(index>=0){
          return myContacts.get(index);
        }
        else return null;
    }

    public void printContacts(){
        if(myContacts.isEmpty()){
            System.out.println("No tienes contactos");
        }
        else {
            System.out.println("Lista de Contactos:");
            for (Contacto myContact : myContacts) {
                System.out.println("1. " + myContact.getName() + " → " + myContact.getPhoneNumber());
            }
        }
    }

    public String getMyNumber() {
        return myNumber;
    }
}
