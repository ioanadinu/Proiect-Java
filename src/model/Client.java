package model;

import java.util.Objects;

public class Client extends Persoana{
    private Integer id;
    private String parola;

    public Client(String nume, String email, Integer id, String parola) {
        super(nume, email);
        this.id = id;
        this.parola = parola;
    }

    public Integer getId() {
        return id;
    }

    public String getParola() {
        return parola;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Override
    public String toString() {
        return "Client{nume='" + getNume() + "\'" +
                ", email='" + getEmail()+ "\'" +
                ", id='" + id + "\'" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(parola, client.parola);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, parola);
    }
}
