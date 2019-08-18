package model;

import java.util.Objects;

public class Locatie {
    private Integer id;
    private String adresa;
    public Locatie(Integer id, String adresa){
        this.id = id;
        this.adresa = adresa;
    }

    public Integer getId() {
        return id;
    }
    public String getAdresa(){
        return adresa;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setAdresa(String adresa){
        this.adresa = adresa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locatie locatie = (Locatie) o;
        return Objects.equals(id, locatie.id) &&
                Objects.equals(adresa, locatie.adresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, adresa);
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "id=" + id +
                ", adresa='" + adresa + '\'' +
                '}';
    }
}
