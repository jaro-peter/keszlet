package com.jaro.keszlet.model;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID )
    private UUID id;

    private String nev;
    private String email;
    private String jelszo;

    public User() {
    }

    public User(UUID id, String nev, String email, String jelszo) {
        this.id = id;
        this.nev = nev;
        this.email = email;
        this.jelszo = jelszo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJelszo() {
        return jelszo;
    }

    public void setJelszo(String jelszo) {
        this.jelszo = jelszo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(nev, user.nev) && Objects.equals(email, user.email) && Objects.equals(jelszo, user.jelszo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nev, email, jelszo);
    }
}
