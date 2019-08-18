package model;

import java.util.Objects;

public class Sala extends Locatie{
    private Integer nrScaune;

    public Sala(Integer id, String adresa, Integer nrScaune) {
        super(id, adresa);
        this.nrScaune = nrScaune;
    }

    public Integer getNrScaune() {
        return nrScaune;
    }

    public void setNrScaune(Integer nrScaune) {
        this.nrScaune = nrScaune;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sala sala = (Sala) o;
        return Objects.equals(nrScaune, sala.nrScaune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nrScaune);
    }

    @Override
    public String toString() {
        return "Sala{adresa=" + getAdresa() +
                ", nrScaune=" + nrScaune +
                '}';
    }
}
