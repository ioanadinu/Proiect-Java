package model;

import static java.lang.Long.valueOf;

public class IdGenerator {
    private Integer idClient;
    private Integer idBilet;
    private Integer idEveniment;
    private Integer idLocatie;

    public IdGenerator() {
        idBilet = 1;
        idClient = 1;
        idEveniment = 1;
        idLocatie = 1;
    }

    public Integer getIdClient() {
        return idClient++;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient + 1;
    }

    public Integer getIdBilet() {
        return idBilet++;
    }

    public void setIdBilet(Integer idBilet) {
        this.idBilet = idBilet + 1;
    }

    public Integer getIdEveniment() {
        return idEveniment++;
    }

    public void setIdEveniment(Integer idEveniment) {
        this.idEveniment = idEveniment + 1;
    }

    public Integer getIdLocatie() {
        return idLocatie++;
    }

    public void setIdLocatie(Integer idLocatie) {
        this.idLocatie = idLocatie + 1;
    }

    @Override
    public String toString() {
        return "IdGenerator{" +
                "idClient=" + idClient +
                ", idBilet=" + idBilet +
                ", idEveniment=" + idEveniment +
                ", idLocatie=" + idLocatie +
                '}';
    }
}
