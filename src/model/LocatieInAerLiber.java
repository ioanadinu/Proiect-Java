package model;

import java.util.Objects;

public class LocatieInAerLiber extends Locatie{
    private Integer nrScaune;
    private Integer nrLocuriPicioare;
    public LocatieInAerLiber(Integer id, String adresa, Integer nrScaune, Integer nrLocuriPicioare){
        super(id, adresa);
        this.nrScaune = nrScaune;
        this.nrLocuriPicioare = nrLocuriPicioare;
    }

    public Integer getNrScaune() {
        return nrScaune;
    }

    public void setNrScaune(Integer nrScaune) {
        this.nrScaune = nrScaune;
    }

    public Integer getNrLocuriPicioare() {
        return nrLocuriPicioare;
    }

    public void setNrLocuriPicioare(Integer nrLocuriPicioare) {
        this.nrLocuriPicioare = nrLocuriPicioare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LocatieInAerLiber that = (LocatieInAerLiber) o;
        return Objects.equals(nrScaune, that.nrScaune) &&
                Objects.equals(nrLocuriPicioare, that.nrLocuriPicioare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nrScaune, nrLocuriPicioare);
    }

    @Override
    public String toString() {
        return "LocatieInAerLiber{adresa=" + getAdresa() +
                ", nrScaune=" + nrScaune +
                ", nrLocuriPicioare=" + nrLocuriPicioare +
                '}';
    }
}
