package model;

import java.util.Objects;

public class Eveniment implements Comparable<Eveniment>{
    private Integer id;
    private Integer idLocatie;
    private String nume;
    private String data;//an luna zi
    private Boolean status;// este sau nu terminat

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Eveniment(Integer id, Integer idLocatie, String nume, String data, Boolean status) {
        this.id = id;
        this.idLocatie = idLocatie;
        this.nume = nume;
        this.data = data;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdLocatie() {
        return idLocatie;
    }

    public void setIdLocatie(Integer idLocatie) {
        this.idLocatie = idLocatie;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Eveniment{" +
                "id=" + id +
                ", idLocatie=" + idLocatie +
                ", nume='" + nume + '\'' +
                ", data='" + data + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eveniment eveniment = (Eveniment) o;
        return id.equals(eveniment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Eveniment o) {
        return this.data.compareTo(o.data);
    }
}
