import Listas.Contacto;
import Listas.TelefonoMovil;

private static final Scanner scanner = new Scanner(System.in);

private static final TelefonoMovil miMovli = new TelefonoMovil("601116015");

void main() {
    boolean quit = false;
    printMenu();

    while (!quit) {
        IO.print("\nElige una opción (6 para ver el menú): ");

        if (!scanner.hasNextInt()) {
            IO.println("Opción inválida. Escribe un número.");
            scanner.nextLine();
            continue;
        }

        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 0 -> {
                IO.println("Saliendo...");
                quit = true;
            }
            case 1 -> printContacts();
            case 2 -> addNewContact();
            case 3 -> updateContact();
            case 4 -> removeContact();
            case 5 -> queryContact();
            case 6 -> printMenu();
            default -> IO.println("Opción no reconocida.");
        }
    }
}

private static void printMenu() {
    IO.println("""
            
            Menú:
            0 - salir
            1 - imprimir contactos
            2 - agregar un nuevo contacto
            3 - actualizar un contacto existente
            4 - eliminar contacto de la lista
            5 - buscar/encontrar contacto por nombre
            6 - volver a imprimir la lista de opciones
            """);
}

private static void printContacts() {
    miMovli.printContacts();
}

private static void addNewContact() {
    IO.print("Nuevo nombre: ");
    String nombreContacto = scanner.nextLine();

    IO.print("Nuevo número de teléfono: ");
    String numeroContacto = validaTelf();

    Contacto newContact = new Contacto(nombreContacto, numeroContacto);

    if (miMovli.addNewContact(newContact)) {
        IO.println("ArrayList.Contacto añadido correctamente.");
    } else {
        IO.println("Error: no se pudo añadir (puede que ya exista).");
    }
}

private static void updateContact() {
    IO.print("Nombre del contacto a actualizar: ");
    String currentName = scanner.nextLine();

    Contacto existingContact = miMovli.queryContact(currentName);
    if (existingContact == null) {
        IO.println("No existe un contacto con ese nombre.");
        return;
    }

    IO.print("Nuevo nombre: ");
    String nombreContacto = scanner.nextLine();

    IO.print("Nuevo número de teléfono: ");
    String numeroContacto = validaTelf();

    Contacto newContact = new Contacto(nombreContacto, numeroContacto);

    if (miMovli.updateContact(existingContact, newContact)) {
        IO.println("ArrayList.Contacto actualizado correctamente.");
    } else {
        IO.println("Error: no se pudo actualizar el contacto.");
    }
}

private static void removeContact() {
    IO.print("Nombre del contacto a eliminar: ");
    String name = scanner.nextLine();

    Contacto existingContact = miMovli.queryContact(name);
    if (existingContact == null) {
        IO.println("No existe un contacto con ese nombre.");
        return;
    }

    if (miMovli.removeContact(existingContact)) {
        IO.println("ArrayList.Contacto eliminado correctamente.");
    } else {
        IO.println("Error: no se pudo eliminar el contacto.");
    }
}

private static void queryContact() {
    IO.print("Nombre del contacto a buscar: ");
    String name = scanner.nextLine();

    Contacto contact = miMovli.queryContact(name);
    if (contact == null) {
        IO.println("No se encontró el contacto.");
    } else {
        IO.println("ArrayList.Contacto encontrado: " + contact.getName() +
                " -> " + contact.getPhoneNumber());
    }
}

private static String validaTelf() {
    String phone;
    boolean valid;

    do {
        System.out.print("Introduce el teléfono (+prefijo número o solo número): ");
        phone = scanner.nextLine().trim();

        // Elimina TODOS los espacios
        String normalized = phone.replaceAll("\\s+", "");

        // Si empieza por +, separamos prefijo y número
        if (normalized.startsWith("+")) {
            // + seguido de 1 a 3 dígitos de prefijo
            if (normalized.matches("^\\+\\d{1,3}\\d+$")) {
                String prefix = normalized.substring(0, 1 + getPrefixLength(normalized));
                String number = normalized.substring(prefix.length());
                normalized = prefix + " " + number;
            }
        }

        valid = normalized.matches("^(\\+\\d{1,3}\\s\\d{7,15}|\\d{7,15})$");

        if (!valid) {
            System.out.println(
                    "Error: formato inválido. Ejemplos válidos:\n" +
                            "  +34 675477848\n" +
                            "  675477848"
            );
        } else {
            phone = normalized; // guardamos versión limpia
        }

    } while (!valid);

    return phone;
}

private static int getPrefixLength(String phone) {
    // phone viene sin espacios y empieza por +
    int i = 1;
    while (i < phone.length() && i <= 3 && Character.isDigit(phone.charAt(i))) {
        i++;
    }
    return i - 1;
}

