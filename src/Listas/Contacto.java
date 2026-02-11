package Listas;

public class Contacto {
    private final String name;
    private final String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void createContact(String name, String phoneNumber) {
        new Contacto(name, phoneNumber);
    }

   @Override
    public boolean equals(Object o) {
       return this.name.equals(((Contacto) o).getName()) || this.phoneNumber.equals(((Contacto) o).getPhoneNumber());
   }

}
