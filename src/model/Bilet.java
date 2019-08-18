package model;

import java.util.Objects;

public class Bilet {
    private Integer id;
    private Integer idClient;
    private String tipLoc;
    private Eveniment eveniment; // sau String numeEveniment??????




    public Bilet(Integer id, Integer idClient, String tipLoc, Eveniment eveniment) {
        this.id = id;
        this.idClient = idClient;
        this.tipLoc = tipLoc;
        this.eveniment = eveniment;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipLoc() {
        return tipLoc;
    }

    public void setTipLoc(String tipLoc) {
        this.tipLoc = tipLoc;
    }

    public Eveniment getEveniment() {
        return eveniment;
    }

    public void setEveniment(Eveniment eveniment) {
        this.eveniment = eveniment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bilet bilet = (Bilet) o;
        return id.equals(bilet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "id=" + id +
                ", idClient=" + idClient +
                ", tipLoc='" + tipLoc + '\'' +
                ", eveniment=" + eveniment +
                '}';
    }
}
