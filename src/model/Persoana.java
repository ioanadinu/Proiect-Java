package model;

import java.util.Objects;

public class Persoana {
    private String nume;
    private String email;

    public Persoana(String nume, String email) {
        this.nume = nume;
        this.email = email;
    }

    public String getNume() {
        return nume;
    }

    public String getEmail() {
        return email;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "nume='" + nume + "\'" +
                ", email='" + email + "\'" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return Objects.equals(nume, persoana.nume) &&
                Objects.equals(email, persoana.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, email);
    }
}
