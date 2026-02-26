package Planetas;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;



public class CuerpoCeleste {
    private final String nombre;
    private final double periodoOrbital;
    private final Set<CuerpoCeleste> satelites;
    private final TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, double periodoOrbital, TipoCuerpoCeleste tipoCuerpo) {
        this.nombre = nombre;
        this.periodoOrbital = periodoOrbital;
        satelites = new HashSet<>();
        this.tipoCuerpo = tipoCuerpo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatelites() {
        return new HashSet<>(satelites);
    }

    public boolean addSatelite(CuerpoCeleste satelite) {
        if (satelites.contains(satelite)) {
            return false;
        }
        satelites.add(satelite);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;                // misma referencia
        if (o == null || getClass() != o.getClass()) return false;

        CuerpoCeleste that = (CuerpoCeleste) o;

        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(tipoCuerpo, that.tipoCuerpo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo);
    }

    @Override
    public String toString() {
        return nombre + ": " + tipoCuerpo + ", " + periodoOrbital;
    }
}
