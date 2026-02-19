package Maps;

import Listas.Contacto;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
   private int id;
   private String descripcion;
   private final Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
    }

    public void addExit(String direccion, int idUbicacion){
        this.exits.put(direccion, idUbicacion);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Integer> getExits() {
        return exits;
    }
}
